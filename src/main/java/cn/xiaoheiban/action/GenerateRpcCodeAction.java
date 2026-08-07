package cn.xiaoheiban.action;

import cn.xiaoheiban.settings.RpcCodeGenDialog;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Action shown under Generate menu in a .proto file editor:
 *   Right-click > Generate > RPC Code (goctl rpc protoc)
 */
public class GenerateRpcCodeAction extends AnAction {

    public GenerateRpcCodeAction() {
        super("RPC Code (goctl rpc protoc)");
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean isProto = file != null && "proto".equalsIgnoreCase(file.getExtension());
        e.getPresentation().setEnabledAndVisible(isProto);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (project == null || file == null) return;

        new RpcCodeGenDialog(project, file.getPath()).show();
    }
}
