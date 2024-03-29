package cn.xiaoheiban.util;

import cn.xiaoheiban.contsant.Constant;
import cn.xiaoheiban.io.IO;
import cn.xiaoheiban.notification.Notification;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.execution.util.ExecUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Exec {
    private static final String SH = "sh";
    private static final String FISH = "fish";
    private static final String DEFAULT_SHELL = SH;
    private static final String COLON_SEPARATOR = ":";
    private static final String SPACE_SEPARATOR = " ";
    private static final String COMMA_SEPARATOR = ";";
    private static final String DEFAULT_SEPARATOR = COLON_SEPARATOR;

    private static String getCurrenShell() {
        ExecResult ret = run(null, "echo $SHELL");
        if (ret.exitCode == 0) {
            if (StringUtil.isEmptyOrSpaces(ret.stdout)) {
                return DEFAULT_SHELL;
            }
            List<String> strings = FileUtil.splitPath(ret.stdout);
            if (strings.isEmpty()) {
                return DEFAULT_SHELL;
            }
            return strings.get(strings.size() - 1);
        }
        return DEFAULT_SHELL;
    }

    public static String lookPath(Project project, String s) {
        String os = System.getProperty("os.name");
        os = os.toLowerCase();
        String pathSeparator = DEFAULT_SEPARATOR;
        String pathCmd = "";
        if (os.startsWith("mac") || os.startsWith("linux")) {
            String currentShell = getCurrenShell();
            if (project != null) {
                Notification.getInstance().log(project, "Use shell: " + currentShell);
            }
            if (FISH.equals(currentShell)) {// Fix issue #13
                pathSeparator = SPACE_SEPARATOR;
            } else {
                pathSeparator = COLON_SEPARATOR;
            }
            pathCmd = "echo $PATH";
        } else if (os.startsWith("windows")) {
            pathCmd = "echo %Path%";
            if (!s.endsWith(".exe")) {
                s = s.concat(".exe");
            }
            pathSeparator = COMMA_SEPARATOR;
        } else {
            Notification.getInstance().error(project, "unsupported os: " + os);
            return null;
        }

        if (findExecutable(s)) {
            return s;
        }

        ExecResult result = run(project, pathCmd);
        if (result == null) {
            return "";
        }
        if (!StringUtil.isEmptyOrSpaces(result.getStderr())) {
            Notification.getInstance().error(project, result.getStderr());
            return "";
        }
        String path = result.getStdout();
        if (StringUtil.isEmptyOrSpaces(path)) {
            return "";
        }

        Notification.getInstance().log(project, "lookup at PATH: " + path);
        String[] splits = path.split(pathSeparator);
        for (String dir : splits) {
            // Unix shell semantics: path element "" means "."
            if (StringUtil.isEmptyOrSpaces(dir)) {
                dir = ".";
            }
            dir = Stringx.trimSpace(dir);
            path = dir + File.separator + s;
            boolean find = findExecutable(path);
            if (!find) {
                continue;
            }
            return path;
        }
        return "";
    }

    private static boolean findExecutable(String path) {
        File file = new File(path);
        return file.canExecute();
    }

    private static List<String> warpCmd(Project project, String arg) {
        String os = System.getProperty("os.name");
        os = os.toLowerCase();
        if (os.startsWith("mac") || os.startsWith("linux")) {
            String shell = System.getenv("SHELL");
            if (StringUtil.isEmptyOrSpaces(shell)) {
                shell = Constant.SH;
            }
            return Arrays.asList(shell, "-c", arg);
        } else if (os.startsWith("windows")) {
            return Arrays.asList(Constant.CMD, "/c", arg);
        } else {
            if (project != null) {
                Notification.getInstance().error(project, "unsupport os: " + os);
            }
            return null;
        }
    }

    public static class ExecResult {
        private String stdout;
        private String stderr;

        private int exitCode;

        public String getStdout() {
            return stdout;
        }

        public void setStdout(String stdout) {
            this.stdout = stdout;
        }

        public String getStderr() {
            return stderr;
        }

        public void setStderr(String stderr) {
            this.stderr = stderr;
        }

        public int getExitCode() {
            return exitCode;
        }

        public void setExitCode(int exitCode) {
            this.exitCode = exitCode;
        }
    }

    public static ExecResult run(Project project, String arg) {
        ExecResult result = new ExecResult();
        try {
            List<String> cmd = warpCmd(project, arg);
            if (cmd == null) {
                return null;
            }
            GeneralCommandLine commandLine = new GeneralCommandLine(cmd);
            ProcessOutput processOutput = ExecUtil.execAndGetOutput(commandLine);
            result.setStdout(processOutput.getStdout());
            result.setStderr(processOutput.getStderr());
            result.setExitCode(processOutput.getExitCode());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setExitCode(1);
            result.setStderr(e.toString());
        }
        return result;
    }

    public static boolean runGoctl(Project project, String arg) {
        String goctl = lookPath(project, "goctl");
        if (StringUtil.isEmptyOrSpaces(goctl)) {
            String userHome = System.getProperty("user.home");
            if (StringUtil.isEmptyOrSpaces(userHome)) {
                Notification.getInstance().error(project, "goctl not found");
                return false;
            }
            goctl = userHome + File.separator + "go" + File.separator + "bin" + File.separator + "goctl";
        }

        Notification.getInstance().log(project, "lookup at the default GOPATH: " + goctl);
        goctl = lookPath(project, goctl);
        Notification.getInstance().log(project, "goctl:" + goctl);
        if (StringUtil.isEmptyOrSpaces(goctl)) {
            Notification.getInstance().error(project, "goctl not found");
            return false;
        }

        String cmd = goctl + " " + arg;
        ExecResult result = run(project, cmd);
        if (result == null) {
            return false;
        }
        Notification.getInstance().log(project, "$ goctl " + arg);
        String stdout = result.getStdout();
        String stderr = result.getStderr();
        Notification.getInstance().log(project, "Exit code " + result.exitCode);
        if (result.exitCode == 0) {
            if (!StringUtil.isEmptyOrSpaces(stdout)) {
                if (stdout.startsWith(Constant.PREFIX_SUCCESS)) {
                    Notification.getInstance().log(project, result.getStdout());
                } else if (stdout.startsWith(Constant.PREFIX_WARNING)) {
                    Notification.getInstance().warning(project, stdout);
                } else if (stdout.startsWith(Constant.PREFIX_ERROR) || stdout.contains(Constant.PREFIX_ERROR2)) {
                    Notification.getInstance().error(project, stdout);
                    return false;
                } else {
                    Notification.getInstance().log(project, stdout);
                }
            }
            return true;
        } else {
            if (!StringUtil.isEmptyOrSpaces(stdout)) {
                Notification.getInstance().error(project, stdout);
            }
            if (!StringUtil.isEmptyOrSpaces(stderr)) {
                Notification.getInstance().error(project, stderr);
            }
            return false;
        }
    }
}
