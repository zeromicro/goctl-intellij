package cn.xiaoheiban.action;

import cn.xiaoheiban.contsant.Constant;
import cn.xiaoheiban.io.IO;
import cn.xiaoheiban.notification.Notification;
import cn.xiaoheiban.ui.FileChooseDialog;
import cn.xiaoheiban.util.Exec;
import cn.xiaoheiban.util.FileReload;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileChooser.FileChooserDialog;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class RpcAction extends AnAction {

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            e.getPresentation().setEnabledAndVisible(false);
            return;
        }
        String extension = file.getExtension();
        if (StringUtil.isEmpty(extension)) {
            e.getPresentation().setEnabledAndVisible(false);
            return;
        }
        if (!extension.equals(Constant.RPC_EXTENSION)) {
            e.getPresentation().setEnabledAndVisible(false);
        }
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            return;
        }
        String path = file.getPath();
        Project project = e.getProject();
        if (project == null) {
            return;
        }
        try {
            String parent = file.getParent().getPath();
            String content = IO.read(file.getInputStream());
            if (content.contains("import")) {
                FileChooseDialog dialog = new FileChooseDialog("请选择proto_path","跳过");
                dialog.setDefaultPath(parent);
                dialog.setOnClickListener(new FileChooseDialog.OnClickListener() {
                    @Override
                    public void onOk(String p) {
                        generateRpc(project, p, path, parent, e);
                    }

                    @Override
                    public void onJump() {
                        generateRpc(project, "", path, parent, e);
                    }
                });
                dialog.showAndGet();
                return;
            }
            generateRpc(project, "", path, parent, e);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void generateRpc(Project project, String protoPath, String src, String target, AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.Backgroundable(project, "generating rpc ...") {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                String command = "rpc proto -src " + src + " -dir " + target + " -idea";
                if (!StringUtil.isEmptyOrSpaces(protoPath)) {
                    command = "rpc proto -src " + src + " -I=" + protoPath + " -dir " + target + " -idea";
                }
                boolean done = Exec.runGoctl(project, command);
                if (done) {
                    FileReload.reloadFromDisk(e);
                    Notification.getInstance().notify(project, "generate rpc done");
                }
            }
        });
    }


}
