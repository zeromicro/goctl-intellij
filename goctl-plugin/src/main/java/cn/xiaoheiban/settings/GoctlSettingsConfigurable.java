package cn.xiaoheiban.settings;

import cn.xiaoheiban.execution.GoctlExecutor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Settings > Tools > Goctl
 */
public class GoctlSettingsConfigurable implements Configurable {

    // goctl binary — browse for executable file, auto-detect on load
    private TextFieldWithBrowseButton goctlPathField;

    private JComboBox<String> styleCombo;

    // template source
    private JBRadioButton radioDefault;
    private JBRadioButton radioLocal;
    private JBRadioButton radioGit;

    private TextFieldWithBrowseButton localDirField;
    private JTextField gitRemoteField;
    private JTextField gitBranchField;
    private JButton fetchBranchesBtn;
    private JComboBox<String> branchCombo;

    private JPanel mainPanel;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Goctl";
    }

    @Override
    public @Nullable JComponent createComponent() {
        buildUI();
        return mainPanel;
    }

    private void buildUI() {
        // ── goctl binary — browse for a single file ───────────────────────
        goctlPathField = new TextFieldWithBrowseButton();
        goctlPathField.addBrowseFolderListener(new TextBrowseFolderListener(
                FileChooserDescriptorFactory.createSingleFileDescriptor()));

        JPanel binaryRow = new JPanel(new BorderLayout(4, 0));
        binaryRow.add(goctlPathField, BorderLayout.CENTER);

        // ── style ─────────────────────────────────────────────────────────
        styleCombo = new JComboBox<>(new String[]{"gozero", "goZero", "go_zero", "GoZero", "GOZERO"});
        styleCombo.setEditable(true);

        // ── template source ───────────────────────────────────────────────
        radioDefault = new JBRadioButton("Built-in (no --home / --remote)");
        radioLocal   = new JBRadioButton("Local directory (--home)");
        radioGit     = new JBRadioButton("Git repository (--remote)");

        ButtonGroup grp = new ButtonGroup();
        grp.add(radioDefault); grp.add(radioLocal); grp.add(radioGit);

        localDirField = new TextFieldWithBrowseButton();
        localDirField.addBrowseFolderListener(new TextBrowseFolderListener(
                FileChooserDescriptorFactory.createSingleFolderDescriptor()));

        gitRemoteField = new JTextField();
        gitBranchField = new JTextField();
        branchCombo    = new JComboBox<>();
        branchCombo.setEditable(true);

        fetchBranchesBtn = new JButton("Fetch Branches");
        fetchBranchesBtn.addActionListener(e -> fetchGitBranches());

        Runnable updateEnabled = () -> {
            boolean local = radioLocal.isSelected();
            boolean git   = radioGit.isSelected();
            localDirField.setEnabled(local);
            gitRemoteField.setEnabled(git);
            gitBranchField.setEnabled(git);
            fetchBranchesBtn.setEnabled(git);
            branchCombo.setEnabled(git);
        };
        radioDefault.addActionListener(e -> updateEnabled.run());
        radioLocal.addActionListener(e -> updateEnabled.run());
        radioGit.addActionListener(e -> updateEnabled.run());

        // git remote row
        JPanel gitRemoteRow = new JPanel(new BorderLayout(4, 0));
        gitRemoteRow.add(gitRemoteField, BorderLayout.CENTER);
        gitRemoteRow.add(fetchBranchesBtn, BorderLayout.EAST);

        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("goctl binary:"), binaryRow)
                .addSeparator()
                .addLabeledComponent(new JBLabel("Naming style (--style):"), styleCombo)
                .addSeparator()
                .addComponent(new JBLabel("Template source:"))
                .addComponent(radioDefault)
                .addComponent(radioLocal)
                .addLabeledComponent(new JBLabel("  Home dir:"), localDirField)
                .addComponent(radioGit)
                .addLabeledComponent(new JBLabel("  Remote URL:"), gitRemoteRow)
                .addLabeledComponent(new JBLabel("  Branch:"), branchCombo)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();

        updateEnabled.run();
    }

    private void fetchGitBranches() {
        String remote = gitRemoteField.getText().trim();
        if (remote.isBlank()) {
            JOptionPane.showMessageDialog(mainPanel, "Please enter a git remote URL first.", "Missing URL", JOptionPane.WARNING_MESSAGE);
            return;
        }
        fetchBranchesBtn.setEnabled(false);
        fetchBranchesBtn.setText("Fetching…");
        branchCombo.removeAllItems();

        new SwingWorker<List<String>, Void>() {
            @Override
            protected List<String> doInBackground() {
                return listGitBranches(remote);
            }

            @Override
            protected void done() {
                try {
                    List<String> branches = get();
                    if (branches.isEmpty()) {
                        JOptionPane.showMessageDialog(mainPanel,
                                "No branches found or unreachable remote.", "No Branches", JOptionPane.WARNING_MESSAGE);
                    } else {
                        for (String b : branches) branchCombo.addItem(b);
                        String cur = GoctlSettings.getInstance().gitBranch;
                        if (!cur.isBlank()) branchCombo.setSelectedItem(cur);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Error: " + ex.getMessage(), "Fetch Failed", JOptionPane.ERROR_MESSAGE);
                } finally {
                    fetchBranchesBtn.setEnabled(true);
                    fetchBranchesBtn.setText("Fetch Branches");
                }
            }
        }.execute();
    }

    private static List<String> listGitBranches(String remote) {
        List<String> result = new ArrayList<>();
        try {
            Process p = new ProcessBuilder("git", "ls-remote", "--heads", remote)
                    .redirectErrorStream(true)
                    .start();
            String out = new String(p.getInputStream().readAllBytes());
            p.waitFor();
            for (String line : out.split("\n")) {
                if (line.contains("refs/heads/")) {
                    String branch = line.replaceAll(".*refs/heads/", "").trim();
                    if (!branch.isBlank()) result.add(branch);
                }
            }
        } catch (Exception ignored) {}
        return result;
    }

    @Override
    public boolean isModified() {
        GoctlSettings s = GoctlSettings.getInstance();
        return !goctlPathField.getText().equals(s.goctlPath)
                || !getSelectedStyle().equals(s.style)
                || !getSelectedSource().equals(s.templateSource)
                || !localDirField.getText().equals(s.localTemplateDir)
                || !gitRemoteField.getText().equals(s.gitRemote)
                || !getSelectedBranch().equals(s.gitBranch);
    }

    @Override
    public void apply() {
        GoctlSettings s = GoctlSettings.getInstance();
        s.goctlPath        = goctlPathField.getText().trim();
        s.style            = getSelectedStyle();
        s.templateSource   = getSelectedSource();
        s.localTemplateDir = localDirField.getText().trim();
        s.gitRemote        = gitRemoteField.getText().trim();
        s.gitBranch        = getSelectedBranch();
    }

    @Override
    public void reset() {
        GoctlSettings s = GoctlSettings.getInstance();

        // Auto-detect goctl path if not configured
        String savedPath = s.goctlPath;
        if (savedPath.isBlank()) {
            String detected = GoctlExecutor.resolveGoctlPath();
            goctlPathField.setText(detected != null ? detected : "");
        } else {
            goctlPathField.setText(savedPath);
        }

        styleCombo.setSelectedItem(s.style);
        localDirField.setText(s.localTemplateDir);
        gitRemoteField.setText(s.gitRemote);

        branchCombo.removeAllItems();
        branchCombo.addItem(s.gitBranch);
        branchCombo.setSelectedItem(s.gitBranch);
        gitBranchField.setText(s.gitBranch);

        switch (s.templateSource) {
            case "local" -> radioLocal.setSelected(true);
            case "git"   -> radioGit.setSelected(true);
            default      -> radioDefault.setSelected(true);
        }
    }

    // ── helpers ───────────────────────────────────────────────────────────

    private String getSelectedStyle() {
        Object item = styleCombo.getSelectedItem();
        return item == null ? "gozero" : item.toString().trim();
    }

    private String getSelectedSource() {
        if (radioLocal.isSelected()) return "local";
        if (radioGit.isSelected())   return "git";
        return "default";
    }

    private String getSelectedBranch() {
        Object item = branchCombo.getSelectedItem();
        String fromCombo = item == null ? "" : item.toString().trim();
        return fromCombo.isBlank() ? gitBranchField.getText().trim() : fromCombo;
    }
}
