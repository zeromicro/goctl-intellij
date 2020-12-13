package cn.xiaoheiban.ui;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.ValidationInfo;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FileChooseDialog extends DialogWrapper {
    private OnClickListener onOkClickListener;
    private String title;

    public interface OnClickListener {
        void onOk(String path);

        void onJump();
    }

    private TextFieldWithBrowseButton textFieldWithBrowseButton;


    public FileChooseDialog(String title,String cancelText) {
        super(true);
        this.title = title;
        init();
        setTitle(title);
        setOKButtonText("确认");
        setCancelButtonText(cancelText);
        this.getButton(myCancelAction).addActionListener(e -> {
           if (onOkClickListener!=null){
               onOkClickListener.onJump();
           }
        });
    }


    public void setDefaultPath(String path) {
        textFieldWithBrowseButton.setText(path);
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        textFieldWithBrowseButton = new TextFieldWithBrowseButton();
        FileChooserDescriptor chooserDescriptor = new FileChooserDescriptor(false, true, false, false, false, false);
        chooserDescriptor.setForcedToUseIdeaFileChooser(true);
        chooserDescriptor.setTitle(title);
        TextBrowseFolderListener listener = new TextBrowseFolderListener(chooserDescriptor);
        textFieldWithBrowseButton.addBrowseFolderListener(listener);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(400, 40));
        panel.add(textFieldWithBrowseButton, BorderLayout.CENTER);
        return panel;
    }

    @Nullable
    @Override
    protected ValidationInfo doValidate() {
        String filePath = textFieldWithBrowseButton.getText();
        VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(filePath);
        if (virtualFile != null) {
            if (this.onOkClickListener != null) {
                this.onOkClickListener.onOk(virtualFile.getPath());
            }
        }
        return null;
    }


    public void setOnClickListener(OnClickListener listener) {
        this.onOkClickListener = listener;
    }

}
