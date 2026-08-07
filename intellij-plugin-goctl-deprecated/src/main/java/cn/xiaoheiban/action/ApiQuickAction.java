package cn.xiaoheiban.action;

import cn.xiaoheiban.actionx.FileAction;
import cn.xiaoheiban.contsant.Constant;
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

public class ApiQuickAction extends FileAction {
    @Override
    public String getExtension() {
        return Constant.API_EXTENSION;
    }


    @Override
    public void performed(@NotNull AnActionEvent e, @NotNull VirtualFile file, @NotNull Project project) {
        String parent = file.getParent().getPath();
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating api ...") {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                String arg = "api go -api " + file.getPath() + " -dir " + parent;
                boolean done = Exec.runGoctl(project, arg);
                if (done) {
                    FileReload.reloadFromDisk(e);
                    Notification.getInstance().notify(project, "generate api done");
                }
            }
        });
    }
}
