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

public class ModelAction extends FileAction {
    @Override
    public String getExtension() {
        return Constant.MODEL_EXTENSION;
    }


    @Override
    public void performed(@NotNull AnActionEvent e, @NotNull VirtualFile file, @NotNull Project project) {
        String parent = file.getParent().getPath();
        FileChooseDialog dialog = new FileChooseDialog("Model Generate Option", "Cancel", false);
        dialog.setDefaultPath(parent);
        dialog.setOnClickListener(new FileChooseDialog.OnClickListener() {
            @Override
            public void onOk(String goctlHome, String output, String protoPath, String style) {
                ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating model ...") {
                    @Override
                    public void run(@NotNull ProgressIndicator indicator) {
                        String src = file.getPath();
                        String arg = "model mysql ddl -c -src " + src + " -dir " + output + " -idea";
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
                            Notification.getInstance().notify(project, "generate model done");
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
