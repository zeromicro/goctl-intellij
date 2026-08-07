package cn.xiaoheiban.action;

import cn.xiaoheiban.settings.ModelCodeGenDialog;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

/**
 * Right-click > Generate > Model Code (goctl model ddl)
 * Only visible for .sql files.
 */
public class GenerateModelCodeAction extends AnAction {

    public GenerateModelCodeAction() {
        super("Model Code (goctl model ddl)");
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean isSql = file != null && "sql".equalsIgnoreCase(file.getExtension());
        e.getPresentation().setEnabledAndVisible(isSql);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (project == null || file == null) return;
        new ModelCodeGenDialog(project, file.getPath()).show();
    }
}
