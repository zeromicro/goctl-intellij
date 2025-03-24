package cn.xiaoheiban.action;

import cn.xiaoheiban.actionx.FileAction;
import cn.xiaoheiban.contsant.Constant;
import cn.xiaoheiban.io.IO;
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
import java.io.IOException;

public class RpcAction extends FileAction {
    @Override
    public void performed(@NotNull AnActionEvent e, @NotNull VirtualFile file, @NotNull Project project) {
        String path = file.getPath();
        try {
            String parent = file.getParent().getPath();
            String content = IO.read(file.getInputStream());
            FileChooseDialog dialog = new FileChooseDialog("zRPC Generate Option", "Cancel", content.contains("import"));
            dialog.setDefaultPath(parent);
            dialog.setOnClickListener(new FileChooseDialog.OnClickListener() {
                @Override
                public void onOk(String goctlHome, String output, String protoPath, String style) {
                    generateRpc(project, goctlHome, protoPath, path, output, style, e);
                }

                @Override
                public void onJump() {
                }
            });
            dialog.showAndGet();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void generateRpc(Project project, String goctlHome, String protoPath, String src, String target, String style, AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating rpc ...") {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                File srcFile = new File(src);
                String protoDir = srcFile.getParent();
                String command = "rpc protoc -I " + protoDir;
                if (!StringUtil.isEmptyOrSpaces(protoPath) && !protoPath.equals(protoDir)) {
                    command += " -I " + protoPath;
                }
                command += " " + src + " --style " + style + " --zrpc_out " + target + " --go_out " + target + " --go-grpc_out " + target;
                if (!StringUtil.isEmptyOrSpaces(goctlHome)) {
                    File file = new File(goctlHome);
                    if (!file.exists()) {
                        Notification.getInstance().warning(project, "goctlHome " + goctlHome + " is not exists");
                    } else {
                        if (file.isDirectory()) {
                            command += " --home " + goctlHome;
                        } else {
                            Notification.getInstance().warning(project, "goctlHome " + goctlHome + " is not a directory");
                        }
                    }
                }
                boolean done = Exec.runGoctl(project, command);
                if (done) {
                    FileReload.reloadFromDisk(e);
                    Notification.getInstance().notify(project, "generate rpc done");
                }
            }
        });
    }

    @Override
    public String getExtension() {
        return Constant.RPC_EXTENSION;
    }
}
