package cn.xiaoheiban.settings;

import cn.xiaoheiban.execution.GoctlConsoleService;
import cn.xiaoheiban.execution.GoctlExecutor;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import com.intellij.util.ui.FormBuilder;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBRadioButton;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Dialog for "Generate > RPC Code (goctl rpc protoc)".
 *
 * Command built:
 *   goctl rpc protoc <protoFile>
 *       --proto_path=<protoDir>   (auto = parent dir of proto file)
 *       --go_out=<goOut>
 *       --go-grpc_out=<grpcOut>
 *       --zrpc_out=<zrpcOut>
 *       [--style <style>]
 *       [--home <home> | --remote <remote> [--branch <branch>]]
 *
 * Console output goes to the Goctl tool window (not inside this dialog).
 */
public class RpcCodeGenDialog extends DialogWrapper {

    private final Project project;
    private final String protoFilePath;

    private JTextField protoFileField;
    private TextFieldWithBrowseButton goOutField;
    private TextFieldWithBrowseButton grpcOutField;
    private TextFieldWithBrowseButton zrpcOutField;
    private JComboBox<String> styleCombo;

    private JBRadioButton radioDefault;
    private JBRadioButton radioLocal;
    private JBRadioButton radioGit;

    private TextFieldWithBrowseButton localDirField;
    private JTextField gitRemoteField;
    private JComboBox<String> branchCombo;
    private JButton fetchBranchesBtn;
    private JLabel errorLabel;

    public RpcCodeGenDialog(@NotNull Project project, @NotNull String protoFilePath) {
        super(project, true);
        this.project = project;
        this.protoFilePath = protoFilePath;
        setTitle("Generate RPC Code (goctl rpc protoc)");
        setOKButtonText("Generate");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        GoctlSettings s = GoctlSettings.getInstance();
        String protoDir = new File(protoFilePath).getParent();
        String pbDir = protoDir != null ? protoDir + "/pb" : "pb";
        String zrpcDir = protoDir != null ? protoDir : ".";

        // proto file (read-only)
        protoFileField = new JTextField(protoFilePath);
        protoFileField.setEditable(false);
        protoFileField.setForeground(UIManager.getColor("TextField.inactiveForeground"));

        // output dirs
        goOutField   = makeDirBrowser(pbDir);
        grpcOutField = makeDirBrowser(pbDir);
        zrpcOutField = makeDirBrowser(zrpcDir);

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
                .addLabeledComponent(new JBLabel("Proto file:"), protoFileField)
                .addSeparator()
                .addLabeledComponent(new JBLabel("--go_out:"), goOutField)
                .addLabeledComponent(new JBLabel("--go-grpc_out:"), grpcOutField)
                .addLabeledComponent(new JBLabel("--zrpc_out:"), zrpcOutField)
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
        GoctlConsoleService console = GoctlConsoleService.getInstance(project);
        console.clear();

        List<String> args = buildArgs();
        File workDir = new File(protoFilePath).getParentFile();

        GoctlExecutor.execute(project, workDir, args,
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
        String protoDir = new File(protoFilePath).getParent();
        List<String> args = new ArrayList<>();
        args.add("rpc");
        args.add("protoc");
        args.add(protoFilePath);
        // proto_path is always set to the proto file's directory
        if (protoDir != null) { args.add("--proto_path=" + protoDir); }
        args.add("--go_out=" + goOutField.getText().trim());
        args.add("--go-grpc_out=" + grpcOutField.getText().trim());
        args.add("--zrpc_out=" + zrpcOutField.getText().trim());

        String style = getSelectedStyle();
        if (!style.isBlank()) { args.add("--style"); args.add(style); }

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

    /** Creates a dir-browsing field using the non-deprecated TextBrowseFolderListener API. */
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
