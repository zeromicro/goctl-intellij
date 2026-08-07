package cn.xiaoheiban.execution;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Factory for the "Goctl" tool window.
 * Content is managed entirely by {@link GoctlConsoleService} on first use.
 */
public class GoctlToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // Leave content management to GoctlConsoleService.getOrCreateConsole().
        // Nothing to add here — the tool window stays empty until the first command runs.
    }
}
