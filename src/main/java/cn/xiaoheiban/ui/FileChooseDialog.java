package cn.xiaoheiban.ui;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class FileChooseDialog extends DialogWrapper {
    private OnClickListener onOkClickListener;
    private String title;
    private boolean showProtoPath;

    public interface OnClickListener {
        void onOk(String goctlHome, String output, String protoPath, String style);

        void onJump();
    }

    private TextFieldWithBrowseButton textFieldWithBrowseButton;
    private TextFieldWithBrowseButton protoPathBrowseButton;
    private TextFieldWithBrowseButton templateBrowseButton;
    private JTextField gozeroTextField;
    private final String stylePropertyKey = "cn.xiaoheiban.go-zero" + "_style";

    public FileChooseDialog(String title, String cancelText, boolean showProtoPath) {
        super(true);
        this.title = title;
        this.showProtoPath = showProtoPath;
        init();
        setTitle(title);
        setOKButtonText("Confirm");
        setCancelButtonText(cancelText);
        this.getButton(myCancelAction).addActionListener(e -> {
            if (onOkClickListener != null) {
                onOkClickListener.onJump();
            }
        });
    }


    public void setDefaultPath(String path) {
        textFieldWithBrowseButton.setText(path);
        if (protoPathBrowseButton != null) {
            protoPathBrowseButton.setText(path);
        }
    }


    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayoutManager(4, 2, new Insets(10, 10, 10, 10), -1, -1));

        Dimension labelDimension = new Dimension(100, -1);
        Dimension textFieldDimension = new Dimension(500, -1);

        final JPanel stylePanel = new JPanel();
        stylePanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel styleLabel = new JLabel();
        styleLabel.setText("Style");
        stylePanel.add(styleLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, labelDimension, null, 0, false));

        // get last style string
        String styleText = PropertiesComponent.getInstance().getValue(stylePropertyKey);
        if ("".equals(styleText) || styleText == null) {
            styleText = "gozero";
        }
        gozeroTextField = new JTextField();
        gozeroTextField.setText(styleText);
        stylePanel.add(gozeroTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, textFieldDimension, null, 0, false));

        final JPanel templatePanel = new JPanel();
        templatePanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel templateLabel = new JLabel();
        templateLabel.setText("Template Path");
        templatePanel.add(templateLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, labelDimension, null, 0, false));
        templateBrowseButton = new TextFieldWithBrowseButton();
        String userHome = System.getProperty("user.home");
        String goctlHome = FileUtil.join(userHome, ".goctl");
        templateBrowseButton.setText(goctlHome);
        FileChooserDescriptor templateChooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
        templateChooserDescriptor.setForcedToUseIdeaFileChooser(true);
        templateChooserDescriptor.setTitle("Choose Template Path");
        TextBrowseFolderListener templateListener = new TextBrowseFolderListener(templateChooserDescriptor);
        templateBrowseButton.addBrowseFolderListener(templateListener);
        templatePanel.add(templateBrowseButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, textFieldDimension, null, 0, false));

        final JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel outputLabel = new JLabel();
        outputLabel.setText("Output");
        outputPanel.add(outputLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, labelDimension, null, 0, false));
        textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
        chooserDescriptor.setForcedToUseIdeaFileChooser(true);
        chooserDescriptor.setTitle("Choose Output Directory");
        TextBrowseFolderListener listener = new TextBrowseFolderListener(chooserDescriptor);
        textFieldWithBrowseButton.addBrowseFolderListener(listener);
        outputPanel.add(textFieldWithBrowseButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, textFieldDimension, null, 0, false));

        contentPane.add(stylePanel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        contentPane.add(outputPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        contentPane.add(templatePanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        if (showProtoPath) {
            final JPanel protoPathPanel = new JPanel();
            protoPathPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
            final JLabel protoPathLabel = new JLabel();
            protoPathLabel.setText("Proto Path");
            protoPathPanel.add(protoPathLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, labelDimension, null, 0, false));
            protoPathBrowseButton = new TextFieldWithBrowseButton();
            FileChooserDescriptor protoPathChooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
            protoPathChooserDescriptor.setForcedToUseIdeaFileChooser(true);
            protoPathChooserDescriptor.setTitle("Proto Path");
            TextBrowseFolderListener protoPathListener = new TextBrowseFolderListener(protoPathChooserDescriptor);
            protoPathBrowseButton.addBrowseFolderListener(protoPathListener);
            protoPathPanel.add(protoPathBrowseButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, textFieldDimension, null, 0, false));
            contentPane.add(protoPathPanel, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        }
        return contentPane;
    }

    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        String goctlHome = templateBrowseButton.getText();
        String outputBrowserPath = textFieldWithBrowseButton.getText();

        // store style string
        String style = gozeroTextField.getText();
        PropertiesComponent.getInstance().setValue(stylePropertyKey, style);


        String output = "", protoPath = "";
        VirtualFile outputFile = LocalFileSystem.getInstance().findFileByPath(outputBrowserPath);
        if (outputFile != null) {
            output = outputFile.getPath();
        }
        if (protoPathBrowseButton != null) {
            String protoBrowserPath = protoPathBrowseButton.getText();
            VirtualFile protoFile = LocalFileSystem.getInstance().findFileByPath(protoBrowserPath);
            if (protoFile != null) {
                protoPath = protoFile.getPath();
            }
        }
        if (this.onOkClickListener != null) {
            this.onOkClickListener.onOk(goctlHome, output, protoPath, style);
        }
        return null;
    }


    public void setOnClickListener(OnClickListener listener) {
        this.onOkClickListener = listener;
    }

}
