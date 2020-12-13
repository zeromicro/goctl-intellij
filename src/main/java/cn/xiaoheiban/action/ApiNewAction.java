package cn.xiaoheiban.action;

import cn.xiaoheiban.notification.Notification;
import cn.xiaoheiban.util.Exec;
import cn.xiaoheiban.util.FileReload;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.testFramework.propertyBased.PsiIndexConsistencyTester;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ApiNewAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) {
            return;
        }
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            return;
        }
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

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            e.getPresentation().setEnabledAndVisible(false);
            return;
        }
        if (!file.isDirectory()) {
            e.getPresentation().setEnabledAndVisible(false);
        }
    }
}
