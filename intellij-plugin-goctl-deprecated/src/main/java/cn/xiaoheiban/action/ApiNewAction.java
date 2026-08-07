package cn.xiaoheiban.action;

import cn.xiaoheiban.actionx.DirAction;
import cn.xiaoheiban.notification.Notification;
import cn.xiaoheiban.util.Exec;
import cn.xiaoheiban.util.FileReload;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ApiNewAction extends DirAction {
    @Override
    public void performed(@NotNull AnActionEvent e, @NotNull VirtualFile file, @NotNull Project project) {
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating api greet service ...") {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                String path = file.getPath();
                boolean done = Exec.runGoctl(project, "api new " + path);
                if (done) {
                    FileReload.reloadFromDisk(e);
                    Notification.getInstance().notify(project, "generate api greet service successful");
                }
            }
        });
    }
}
