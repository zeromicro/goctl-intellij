package cn.xiaoheiban.action;

import cn.xiaoheiban.ApiFileType;
import cn.xiaoheiban.settings.GoCodeGenDialog;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Action shown under Generate menu in the .api file editor:
 *   Right-click > Generate > Go Code (goctl api go)
 */
public class GenerateGoCodeAction extends AnAction {

    public GenerateGoCodeAction() {
        super("Go Code (goctl api go)");
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean isApiFile = file != null && ApiFileType.INSTANCE.equals(file.getFileType());
        e.getPresentation().setEnabledAndVisible(isApiFile);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (project == null || file == null) return;

        String apiPath = file.getPath();
        GoCodeGenDialog dialog = new GoCodeGenDialog(project, apiPath);
        dialog.show();
    }
}
