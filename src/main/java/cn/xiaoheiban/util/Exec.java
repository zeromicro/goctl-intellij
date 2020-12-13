package cn.xiaoheiban.util;

import cn.xiaoheiban.contsant.Constant;
import cn.xiaoheiban.io.IO;
import cn.xiaoheiban.notification.Notification;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Exec {

    public static String lookPath(Project project, String s) {

        String os = System.getProperty("os.name");
        os = os.toLowerCase();
        String pathSeparator = File.pathSeparator;
        String pathCmd = "";
        if (os.startsWith("mac") || os.startsWith("linux")) {
            pathCmd = "echo $PATH";
        } else if (os.startsWith("windows")) {
            pathCmd = "echo %Path%";
            if (!s.endsWith(".exe")){
                s=s.concat(".exe");
            }
            pathSeparator = ";";
        } else {
            Notification.getInstance().error(project, "unsupport os: " + os);
            return null;
        }

        if (s.contains(File.separator)) {
            if (findExecutable(s)) {
                return s;
            }
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
            Notification.getInstance().error(project, "unsupport os: " + os);
            return null;
        }
    }

    public static class ExecResult {
        private String stdout;
        private String stderr;

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
    }

    public static ExecResult run(Project project, String arg) {
        ExecResult result = new ExecResult();
        try {
            List<String> cmd = warpCmd(project, arg);
            if (cmd == null) {
                return null;
            }
            GeneralCommandLine commandLine = new GeneralCommandLine(cmd);
            Process process = commandLine.createProcess();
            result.setStdout(IO.read(process.getInputStream()));
            result.setStderr(IO.read(process.getErrorStream()));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setStderr(e.toString());
        }
        return result;
    }

    public static boolean runGoctl(Project project, String arg) {
        String goctl = lookPath(project, "goctl");
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
        if (!StringUtil.isEmptyOrSpaces(stdout)) {
            if (stdout.startsWith(Constant.PREFIX_SUCCESS)) {
                Notification.getInstance().log(project, result.getStdout());
            } else if (stdout.startsWith(Constant.PREFIX_WARNING)) {
                Notification.getInstance().warning(project, result.getStdout());
            } else if (stdout.startsWith(Constant.PREFIX_ERROR) || stdout.contains(Constant.PREFIX_ERROR2)) {
                Notification.getInstance().error(project, result.getStdout());
                return false;
            } else {
                Notification.getInstance().log(project, result.getStdout());
            }
            return true;
        }
        if (!StringUtil.isEmptyOrSpaces(stderr)) {
            Notification.getInstance().error(project, stderr);
        }
        return false;
    }
}
