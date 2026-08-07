package cn.xiaoheiban.settings;

import cn.xiaoheiban.execution.GoctlConsoleService;
import cn.xiaoheiban.execution.GoctlExecutor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Dialog for "Generate > Go Code (goctl api go)".
 * Console output goes to the Goctl tool window, not inside this dialog.
 */
public class GoCodeGenDialog extends DialogWrapper {

    private final Project project;
    private final String apiFilePath;

    private JTextField apiFileField;
    private TextFieldWithBrowseButton outputDirField;
    private JComboBox<String> styleCombo;

    private JBRadioButton radioDefault;
    private JBRadioButton radioLocal;
    private JBRadioButton radioGit;

    private TextFieldWithBrowseButton localDirField;
    private JTextField gitRemoteField;
    private JComboBox<String> branchCombo;
    private JButton fetchBranchesBtn;

    private JLabel errorLabel;

    public GoCodeGenDialog(@NotNull Project project, @NotNull String apiFilePath) {
        super(project, true);
        this.project = project;
        this.apiFilePath = apiFilePath;
        setTitle("Generate Go Code (goctl api go)");
        setOKButtonText("Generate");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        GoctlSettings s = GoctlSettings.getInstance();
        String defaultDir = new File(apiFilePath).getParent();

        // api file (read-only)
        apiFileField = new JTextField(apiFilePath);
        apiFileField.setEditable(false);
        apiFileField.setForeground(UIManager.getColor("TextField.inactiveForeground"));

        // output dir
        outputDirField = makeDirBrowser(defaultDir != null ? defaultDir : ".");

        // style
        styleCombo = new JComboBox<>(new String[]{"gozero", "goZero", "go_zero", "GoZero", "GOZERO"});
        styleCombo.setEditable(true);
        styleCombo.setSelectedItem(s.style);

        // template source
        radioDefault = new JBRadioButton("Built-in");
        radioLocal   = new JBRadioButton("Local dir (--home)");
        radioGit     = new JBRadioButton("Git repo (--remote)");
        ButtonGroup grp = new ButtonGroup();
        grp.add(radioDefault); grp.add(radioLocal); grp.add(radioGit);

        localDirField  = makeDirBrowser(s.localTemplateDir);
        gitRemoteField = new JTextField(s.gitRemote);
        branchCombo    = new JComboBox<>();
        branchCombo.setEditable(true);
        branchCombo.addItem(s.gitBranch);
        branchCombo.setSelectedItem(s.gitBranch);

        fetchBranchesBtn = new JButton("Fetch Branches");
        fetchBranchesBtn.addActionListener(e -> fetchBranches());

        switch (s.templateSource) {
            case "local" -> radioLocal.setSelected(true);
            case "git"   -> radioGit.setSelected(true);
            default      -> radioDefault.setSelected(true);
        }

        Runnable sync = () -> {
            boolean local = radioLocal.isSelected();
            boolean git   = radioGit.isSelected();
            localDirField.setEnabled(local);
            gitRemoteField.setEnabled(git);
            fetchBranchesBtn.setEnabled(git);
            branchCombo.setEnabled(git);
        };
        radioDefault.addActionListener(e -> sync.run());
        radioLocal.addActionListener(e -> sync.run());
        radioGit.addActionListener(e -> sync.run());
        sync.run();

        JPanel gitRemoteRow = new JPanel(new java.awt.BorderLayout(4, 0));
        gitRemoteRow.add(gitRemoteField, java.awt.BorderLayout.CENTER);
        gitRemoteRow.add(fetchBranchesBtn, java.awt.BorderLayout.EAST);

        JPanel templatePanel = new JPanel(new java.awt.GridLayout(0, 1, 0, 2));
        templatePanel.add(radioDefault);
        templatePanel.add(radioLocal);
        templatePanel.add(FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("    Home dir:"), localDirField).getPanel());
        templatePanel.add(radioGit);
        templatePanel.add(FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("    Remote:"), gitRemoteRow).getPanel());
        templatePanel.add(FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("    Branch:"), branchCombo).getPanel());

        return FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("API file:"), apiFileField)
                .addLabeledComponent(new JBLabel("Output dir:"), outputDirField)
                .addLabeledComponent(new JBLabel("Style (--style):"), styleCombo)
                .addSeparator()
                .addComponent(new JBLabel("Template source:"))
                .addComponent(templatePanel)
                .addComponent(buildErrorLabel())
                .getPanel();
    }

    private JLabel buildErrorLabel() {
        errorLabel = new JLabel(" ");
        errorLabel.setForeground(JBColor.RED);
        errorLabel.setVisible(false);
        return errorLabel;
    }

    @Override
    protected void doOKAction() {
        getOKAction().setEnabled(false);
        errorLabel.setVisible(false);
        GoctlConsoleService.getInstance(project).clear();

        List<String> args = buildArgs();
        File workDir = new File(outputDirField.getText().trim());
        if (!workDir.exists()) workDir = new File(apiFilePath).getParentFile();

        final File wd = workDir;
        GoctlExecutor.execute(project, wd, args,
                line -> {},
                exitCode -> SwingUtilities.invokeLater(() -> {
                    getOKAction().setEnabled(true);
                    if (exitCode == 0) {
                        VirtualFileManager.getInstance().asyncRefresh(null);
                        super.doOKAction();
                    } else {
                        showError(exitCode);
                    }
                }));
    }

    private void showError(int exitCode) {
        String msg = exitCode == -1
                ? "⚠ goctl not found or failed to start. Check notification for details."
                : "⚠ goctl exited with code " + exitCode + ". See the Goctl output window for details.";
        errorLabel.setText(msg);
        errorLabel.setVisible(true);
    }

    private List<String> buildArgs() {
        List<String> args = new ArrayList<>(List.of("api", "go",
                "--api", apiFilePath,
                "--dir", outputDirField.getText().trim()));

        String style = getSelectedStyle();
        if (!style.equals("default")) { args.add("--style"); args.add(style); }

        args.addAll(templateFlags());
        return args;
    }

    private List<String> templateFlags() {
        if (radioLocal.isSelected()) {
            String home = localDirField.getText().trim();
            if (!home.isBlank()) return List.of("--home", home);
        } else if (radioGit.isSelected()) {
            String remote = gitRemoteField.getText().trim();
            if (!remote.isBlank()) {
                List<String> flags = new ArrayList<>(List.of("--remote", remote));
                String branch = getSelectedBranch();
                if (!branch.isBlank()) { flags.add("--branch"); flags.add(branch); }
                return flags;
            }
        }
        return List.of();
    }

    private void fetchBranches() {
        String remote = gitRemoteField.getText().trim();
        if (remote.isBlank()) {
            JOptionPane.showMessageDialog(getContentPanel(), "Please enter a remote URL first.",
                    "Missing URL", JOptionPane.WARNING_MESSAGE);
            return;
        }
        fetchBranchesBtn.setEnabled(false);
        fetchBranchesBtn.setText("Fetching…");

        new SwingWorker<List<String>, Void>() {
            @Override protected List<String> doInBackground() { return listBranches(remote); }
            @Override protected void done() {
                try {
                    List<String> branches = get();
                    branchCombo.removeAllItems();
                    if (branches.isEmpty()) {
                        JOptionPane.showMessageDialog(getContentPanel(),
                                "No branches found.", "No Branches", JOptionPane.WARNING_MESSAGE);
                    } else {
                        branches.forEach(branchCombo::addItem);
                        branchCombo.setSelectedIndex(0);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(getContentPanel(),
                            "Fetch failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    fetchBranchesBtn.setEnabled(true);
                    fetchBranchesBtn.setText("Fetch Branches");
                }
            }
        }.execute();
    }

    private static List<String> listBranches(String remote) {
        List<String> result = new ArrayList<>();
        try {
            Process p = new ProcessBuilder("git", "ls-remote", "--heads", remote)
                    .redirectErrorStream(true).start();
            String out = new String(p.getInputStream().readAllBytes());
            p.waitFor();
            for (String line : out.split("\n")) {
                if (line.contains("refs/heads/")) {
                    String b = line.replaceAll(".*refs/heads/", "").trim();
                    if (!b.isBlank()) result.add(b);
                }
            }
        } catch (Exception ignored) {}
        return result;
    }

    private TextFieldWithBrowseButton makeDirBrowser(String defaultText) {
        var field = new TextFieldWithBrowseButton();
        field.setText(defaultText);
        field.addBrowseFolderListener(new TextBrowseFolderListener(
                FileChooserDescriptorFactory.createSingleFolderDescriptor(), project));
        return field;
    }

    private String getSelectedStyle() {
        Object item = styleCombo.getSelectedItem();
        return item == null ? "gozero" : item.toString().trim();
    }

    private String getSelectedBranch() {
        Object item = branchCombo.getSelectedItem();
        return item == null ? "" : item.toString().trim();
    }
}
