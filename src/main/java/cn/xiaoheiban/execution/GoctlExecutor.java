package cn.xiaoheiban.execution;

import cn.xiaoheiban.settings.GoctlSettings;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessAdapter;
import com.intellij.execution.process.ProcessEvent;
import com.intellij.execution.process.ProcessOutputType;
import cn.xiaoheiban.settings.GoctlSettingsConfigurable;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationAction;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.options.ShowSettingsUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public final class GoctlExecutor {

    private static final Logger LOG = Logger.getInstance(GoctlExecutor.class);
    private static final String NOTIFICATION_GROUP = "Goctl";

    private static final List<String> COMMON_PATHS = List.of(
            "/usr/local/bin/goctl",
            "/usr/bin/goctl",
            System.getProperty("user.home") + "/go/bin/goctl",
            System.getProperty("user.home") + "/.goctl/goctl"
    );

    private GoctlExecutor() {}

    // ── Binary resolution ─────────────────────────────────────────────────

    @Nullable
    public static String resolveGoctlPath() {
        String configured = GoctlSettings.getInstance().goctlPath;
        if (!configured.isBlank() && new File(configured).canExecute()) {
            return configured;
        }
        String fromPath = findOnSystemPath("goctl");
        if (fromPath != null) return fromPath;
        for (String path : COMMON_PATHS) {
            if (new File(path).canExecute()) return path;
        }
        return null;
    }

    @Nullable
    private static String findOnSystemPath(String name) {
        try {
            String cmd = System.getProperty("os.name").toLowerCase().contains("win") ? "where" : "which";
            Process p = new ProcessBuilder(cmd, name).start();
            String out = new String(p.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
            p.waitFor();
            if (!out.isBlank() && new File(out.lines().findFirst().orElse("")).canExecute()) {
                return out.lines().findFirst().orElse(null);
            }
        } catch (Exception ignored) {}
        return null;
    }

    // ── Notification helpers ──────────────────────────────────────────────

    /** Shows a plain error balloon. */
    private static void notifyError(@Nullable Project project, @NotNull String title, @NotNull String content) {
        showNotification(project, title, content, false);
    }

    /**
     * Shows an error balloon with a "Configure Goctl..." action that opens
     * Settings > Tools > Goctl directly.
     */
    private static void notifyErrorWithSettings(@Nullable Project project, @NotNull String title, @NotNull String content) {
        showNotification(project, title, content, true);
    }

    private static void showNotification(@Nullable Project project, @NotNull String title,
                                         @NotNull String content, boolean addSettingsLink) {
        ApplicationManager.getApplication().invokeLater(() -> {
            try {
                Notification notification = NotificationGroupManager.getInstance()
                        .getNotificationGroup(NOTIFICATION_GROUP)
                        .createNotification(title, content, NotificationType.ERROR);
                if (addSettingsLink) {
                    notification.addAction(NotificationAction.createSimple(
                            "Configure Goctl…",
                            () -> ShowSettingsUtil.getInstance()
                                    .showSettingsDialog(project, GoctlSettingsConfigurable.class)
                    ));
                }
                notification.notify(project);
            } catch (Exception e) {
                LOG.warn("Failed to show error notification", e);
            }
        });
    }

    /** Prints error to console (red), activates the tool window, and pops a balloon notification. */
    private static void reportFatalError(@Nullable Project project,
                                         @NotNull Consumer<String> onOutput,
                                         @NotNull String message,
                                         boolean offerSettingsLink) {
        onOutput.accept(message);
        if (project != null) {
            GoctlConsoleService svc = GoctlConsoleService.getInstance(project);
            svc.print(message, true);
            svc.activate();
        }
        if (offerSettingsLink) {
            notifyErrorWithSettings(project, "Goctl Error", message);
        } else {
            notifyError(project, "Goctl Error", message);
        }
    }

    // ── Execution ─────────────────────────────────────────────────────────

    public static void execute(
            @Nullable Project project,
            @NotNull File workDir,
            @NotNull List<String> args,
            @NotNull Consumer<String> onOutput,
            @Nullable Consumer<Integer> onFinished) {

        String binary = resolveGoctlPath();
        if (binary == null) {
            String msg = "[ERROR] goctl binary not found. Please configure its path in Settings > Tools > Goctl.";
            reportFatalError(project, onOutput, msg, true);   // ← Settings link
            if (onFinished != null) onFinished.accept(-1);
            return;
        }

        List<String> cmd = new ArrayList<>();
        cmd.add(binary);
        cmd.addAll(args);

        // Print raw command so user always sees what was run
        String cmdLine = "$ " + String.join(" ", cmd);
        onOutput.accept(cmdLine);
        if (project != null) {
            GoctlConsoleService svc = GoctlConsoleService.getInstance(project);
            svc.print(cmdLine + "\n", false);
            svc.activate();
        }

        try {
            GeneralCommandLine commandLine = new GeneralCommandLine(cmd)
                    .withWorkDirectory(workDir)
                    .withCharset(StandardCharsets.UTF_8);

            OSProcessHandler handler = new OSProcessHandler(commandLine);

            handler.addProcessListener(new ProcessAdapter() {
                @Override
                public void onTextAvailable(@NotNull ProcessEvent event, @NotNull Key outputType) {
                    String text = event.getText();
                    if (text != null && !text.isBlank()) {
                        boolean isErr = outputType == ProcessOutputType.STDERR;
                        onOutput.accept(text.stripTrailing());
                        if (project != null) {
                            GoctlConsoleService.getInstance(project).print(text, isErr);
                        }
                    }
                }

                @Override
                public void processTerminated(@NotNull ProcessEvent event) {
                    int exitCode = event.getExitCode();
                    boolean failed = exitCode != 0;
                    String msg = failed
                            ? "[FAILED]  goctl exited with code " + exitCode + "."
                            : "[SUCCESS] goctl exited with code 0.";
                    onOutput.accept(msg);
                    if (project != null) {
                        GoctlConsoleService svc = GoctlConsoleService.getInstance(project);
                        svc.print(msg + "\n", failed);
                        if (failed) {
                            svc.activate();
                            notifyError(project, "Goctl Failed",
                                    "goctl exited with code " + exitCode + ". See the Goctl output window for details.");
                        }                    }
                    if (onFinished != null) onFinished.accept(exitCode);
                }
            });

            handler.startNotify();
        } catch (Exception e) {
            String err = "[ERROR] Failed to start goctl: " + e.getMessage();
            reportFatalError(project, onOutput, err, true);   // ← Settings link
            LOG.warn(err, e);
            if (onFinished != null) onFinished.accept(-1);
        }
    }

    public static int executeSync(
            @Nullable Project project,
            @NotNull File workDir,
            @NotNull List<String> args,
            @NotNull Consumer<String> onOutput) {

        int[] code = {0};
        Object lock = new Object();
        boolean[] done = {false};

        execute(project, workDir, args, onOutput, exitCode -> {
            synchronized (lock) {
                code[0] = exitCode;
                done[0] = true;
                lock.notifyAll();
            }
        });

        synchronized (lock) {
            while (!done[0]) {
                try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
            }
        }
        return code[0];
    }

    public static List<String> styleFlags(@NotNull String style) {
        if (style.isBlank() || style.equals("default")) return List.of();
        return Arrays.asList("--style", style);
    }

    public static List<String> templateFlags(@NotNull String source, @NotNull String home,
                                              @NotNull String remote, @NotNull String branch) {
        return switch (source) {
            case "local"  -> home.isBlank() ? List.of() : Arrays.asList("--home", home);
            case "git"    -> {
                List<String> flags = new ArrayList<>(Arrays.asList("--remote", remote));
                if (!branch.isBlank()) { flags.add("--branch"); flags.add(branch); }
                yield flags;
            }
            default -> List.of();
        };
    }
}
