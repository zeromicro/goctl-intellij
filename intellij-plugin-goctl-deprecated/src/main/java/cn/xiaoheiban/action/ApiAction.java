package cn.xiaoheiban.action;

import cn.xiaoheiban.actionx.FileAction;
import cn.xiaoheiban.contsant.Constant;
import cn.xiaoheiban.notification.Notification;
import cn.xiaoheiban.ui.FileChooseDialog;
import cn.xiaoheiban.util.Exec;
import cn.xiaoheiban.util.FileReload;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ApiAction extends FileAction {
    @Override
    public String getExtension() {
        return Constant.API_EXTENSION;
    }

    @Override
    public void performed(@NotNull AnActionEvent e, @NotNull VirtualFile file, @NotNull Project project) {
        String parent = file.getParent().getPath();
        FileChooseDialog dialog = new FileChooseDialog("API Generate Option", "Cancel", false,false);
        dialog.setDefaultPath(parent);
        dialog.setOnClickListener(new FileChooseDialog.OnClickListener() {
            @Override
            public void onOk(String goctlHome, String output, String protoPath, String style,boolean group,boolean client) {
                ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating api ...") {
                    @Override
                    public void run(@NotNull ProgressIndicator indicator) {
                        String arg = "api go -api " + file.getPath() + " -dir " + output;
                        if (!StringUtil.isEmptyOrSpaces(style)) {
                            arg += " --style " + style;
                        }
                        if (!StringUtil.isEmptyOrSpaces(goctlHome)) {
                            File file = new File(goctlHome);
                            if (!file.exists()) {
                                Notification.getInstance().warning(project, "goctlHome " + goctlHome + " is not exists");
                            } else {
                                if (file.isDirectory()) {
                                    arg += " --home " + goctlHome;
                                } else {
                                    Notification.getInstance().warning(project, "goctlHome " + goctlHome + " is not a directory");
                                }
                            }
                        }
                        boolean done = Exec.runGoctl(project, arg);
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
