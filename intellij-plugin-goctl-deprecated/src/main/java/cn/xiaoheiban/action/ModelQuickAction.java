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

public class ModelQuickAction extends FileAction {
    @Override
    public String getExtension() {
        return Constant.MODEL_EXTENSION;
    }


    @Override
    public void performed(@NotNull AnActionEvent e, @NotNull VirtualFile file, @NotNull Project project) {
        String parent = file.getParent().getPath();
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating model ...") {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                String src = file.getPath();
                String arg = "model mysql ddl -c -src " + src + " -dir " + parent + " -idea";
                boolean done = Exec.runGoctl(project, arg);
                if (done) {
                    FileReload.reloadFromDisk(e);
                    Notification.getInstance().notify(project, "generate model done");
                }
            }
        });
    }
}
