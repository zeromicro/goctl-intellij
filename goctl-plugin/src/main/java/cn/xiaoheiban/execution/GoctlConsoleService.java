package cn.xiaoheiban.execution;

import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

@Service(Service.Level.PROJECT)
public final class GoctlConsoleService {

    static final String TOOL_WINDOW_ID = "Goctl";

    private final Project project;
    private ConsoleView console;

    public GoctlConsoleService(@NotNull Project project) {
        this.project = project;
    }

    public static GoctlConsoleService getInstance(@NotNull Project project) {
        return project.getService(GoctlConsoleService.class);
    }

    public void print(@NotNull String text, boolean isError) {
        SwingUtilities.invokeLater(() -> {
            ConsoleView cv = getOrCreateConsole();
            ConsoleViewContentType type = isError
                    ? ConsoleViewContentType.ERROR_OUTPUT
                    : ConsoleViewContentType.NORMAL_OUTPUT;
            cv.print(text.endsWith("\n") ? text : text + "\n", type);

            ToolWindow tw = ToolWindowManager.getInstance(project).getToolWindow(TOOL_WINDOW_ID);
            if (tw != null && !tw.isActive()) {
                tw.activate(null, false, false);
            }
        });
    }

    public void clear() {
        SwingUtilities.invokeLater(() -> getOrCreateConsole().clear());
    }

    /** Activates (brings to front) the Goctl tool window so errors are immediately visible. */
    public void activate() {
        SwingUtilities.invokeLater(() -> {
            ToolWindow tw = ToolWindowManager.getInstance(project).getToolWindow(TOOL_WINDOW_ID);
            if (tw != null && !tw.isVisible()) {
                tw.activate(null, true, true);
            }
        });
    }

    /**
     * Returns the single shared ConsoleView, creating it once and registering it
     * in the tool window. Subsequent calls always return the same instance —
     * no duplicate content tabs are ever added.
     */
    ConsoleView getOrCreateConsole() {
        if (console != null) return console;

        console = TextConsoleBuilderFactory.getInstance()
                .createBuilder(project)
                .getConsole();

        ToolWindow tw = ToolWindowManager.getInstance(project).getToolWindow(TOOL_WINDOW_ID);
        if (tw != null) {
            // Remove any placeholder content added by GoctlToolWindowFactory
            tw.getContentManager().removeAllContents(true);

            Content content = ContentFactory.getInstance()
                    .createContent(console.getComponent(), "Output", false);
            content.setDisposer(console);
            tw.getContentManager().addContent(content);
        }
        return console;
    }
}
