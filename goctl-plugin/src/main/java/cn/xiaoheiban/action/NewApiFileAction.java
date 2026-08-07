package cn.xiaoheiban.action;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * New > API File  — creates a new .api file from a user-chosen template.
 */
public class NewApiFileAction extends AnAction {

    public NewApiFileAction() {
        super("New Api File", "Create a new .api file",
                IconLoader.getIcon("/icons/goctl.png", NewApiFileAction.class));
    }

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        // Enable when there's a directory context (project view or editor)
        Project project = e.getProject();
        VirtualFile file = e.getData(CommonDataKeys.VIRTUAL_FILE);
        boolean enabled = project != null && file != null;
        e.getPresentation().setEnabledAndVisible(enabled);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getProject();
        VirtualFile contextFile = e.getData(CommonDataKeys.VIRTUAL_FILE);
        if (project == null || contextFile == null) return;

        // Resolve target directory
        VirtualFile targetDir = contextFile.isDirectory() ? contextFile : contextFile.getParent();
        if (targetDir == null) return;

        NewApiFileDialog dialog = new NewApiFileDialog(project);
        if (!dialog.showAndGet()) return;

        String fileName = dialog.getFileName();
        String content  = dialog.getTemplateContent();

        WriteCommandAction.runWriteCommandAction(project, "New API File", null, () -> {
            try {
                // Ensure .api extension
                String name = fileName.endsWith(".api") ? fileName : fileName + ".api";
                VirtualFile newFile = targetDir.createChildData(this, name);
                newFile.setBinaryContent(content.getBytes(StandardCharsets.UTF_8));
                // Open in editor
                ApplicationManager.getApplication().invokeLater(() ->
                        FileEditorManager.getInstance(project).openFile(newFile, true));
            } catch (IOException ex) {
                com.intellij.openapi.diagnostic.Logger
                        .getInstance(NewApiFileAction.class).warn("Failed to create .api file", ex);
            }
        });
    }

    // ── Inner dialog ────────────────────────────────────────────────────────

    private static final class NewApiFileDialog extends DialogWrapper {

        private JTextField nameField;
        private JBRadioButton radioEmpty;
        private JBRadioButton radioTemplate;

        NewApiFileDialog(@NotNull Project project) {
            super(project, false);
            setTitle("New API File");
            setOKButtonText("Create");
            init();
        }

        @Override
        protected @Nullable JComponent createCenterPanel() {
            nameField = new JTextField("", 30);
            nameField.setToolTipText("File name (without extension)");

            radioEmpty    = new JBRadioButton("Empty file", true);
            radioTemplate = new JBRadioButton("Full template (Api Template)");

            ButtonGroup grp = new ButtonGroup();
            grp.add(radioEmpty); grp.add(radioTemplate);

            JPanel templatePanel = new JPanel(new java.awt.GridLayout(0, 1, 0, 2));
            templatePanel.add(radioEmpty);
            templatePanel.add(radioTemplate);

            return FormBuilder.createFormBuilder()
                    .addLabeledComponent(new JBLabel("File name:"), nameField)
                    .addLabeledComponent(new JBLabel("Template:"), templatePanel)
                    .getPanel();
        }

        @Override
        public @Nullable JComponent getPreferredFocusedComponent() {
            return nameField;
        }

        @Override
        protected @Nullable ValidationInfo doValidate() {
            if (nameField.getText().trim().isEmpty()) {
                return new ValidationInfo("File name cannot be empty.", nameField);
            }
            return null;
        }

        String getFileName() {
            return nameField.getText().trim();
        }

        String getTemplateContent() {
            if (radioTemplate.isSelected()) return loadTemplate("fileTemplates/internal/Api Template.api.ft");
            return loadTemplate("fileTemplates/internal/Api File.api.ft"); // empty (info only)
        }

        private static String loadTemplate(String resourcePath) {
            try (InputStream in = NewApiFileDialog.class.getClassLoader().getResourceAsStream(resourcePath)) {
                if (in == null) return "";
                return new String(in.readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                return "";
            }
        }
    }
}
