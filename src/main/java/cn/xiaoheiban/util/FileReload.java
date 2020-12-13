package cn.xiaoheiban.util;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

public class FileReload {
    public static void reloadFromDisk(AnActionEvent e) {
        if (e == null) {
            return;
        }
        Project project = e.getProject();
        if (project == null) {
            return;
        }
        project.save();
        VirtualFile file = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (file == null) {
            return;
        }
        file.getFileSystem().refresh(true);
    }
}
