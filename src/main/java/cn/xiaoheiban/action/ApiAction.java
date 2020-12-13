package cn.xiaoheiban.action;

import cn.xiaoheiban.contsant.Constant;
import cn.xiaoheiban.notification.Notification;
import cn.xiaoheiban.ui.FileChooseDialog;
import cn.xiaoheiban.util.Exec;
import cn.xiaoheiban.util.FileReload;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ApiAction extends AnAction {
    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            return;
        }
        String extension = file.getExtension();
        if (StringUtil.isEmpty(extension)) {
            e.getPresentation().setEnabledAndVisible(false);
            return;
        }
        if (!extension.equals(Constant.API_EXTENSION)) {
            e.getPresentation().setEnabledAndVisible(false);
        }
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            return;
        }
        Project project = e.getProject();
        if (project == null) {
            return;
        }
        String parent = file.getParent().getPath();
        FileChooseDialog dialog = new FileChooseDialog("请选择生成目录", "取消");
        dialog.setDefaultPath(parent);
        dialog.setOnClickListener(new FileChooseDialog.OnClickListener() {
            @Override
            public void onOk(String p) {
                ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating api ...") {
                    @Override
                    public void run(@NotNull ProgressIndicator indicator) {
                        boolean done = Exec.runGoctl(project, "api go -api " + file.getPath() + " -dir " + p);
                        if (done) {
                            FileReload.reloadFromDisk(e);
                            Notification.getInstance().notify(project, "generate api done");
                        }
                    }
                });
            }

            @Override
            public void onJump() {

            }
        });
        dialog.showAndGet();
    }
}
