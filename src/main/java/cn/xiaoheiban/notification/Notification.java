package cn.xiaoheiban.notification;

import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;

public class Notification {
    private static Notification notification;
    private final NotificationGroup POP = new NotificationGroup("goctl-pop", NotificationDisplayType.BALLOON, true);
    private final NotificationGroup LOG = new NotificationGroup("goctl-log", NotificationDisplayType.NONE, true);

    private Notification() {
    }

    public static Notification getInstance() {
        if (notification == null) {
            notification = new Notification();
        }
        return notification;
    }

    public void notify(Project project, String content) {
        if (project == null) {
            return;
        }
        final com.intellij.notification.Notification notification = POP.createNotification(unWrapMsg(content), NotificationType.INFORMATION);
        notification.notify(project);
    }

    public void log(Project project, String content) {
        if (project == null) {
            return;
        }
        final com.intellij.notification.Notification notification = LOG.createNotification(unWrapMsg(content), NotificationType.INFORMATION);
        notification.notify(project);
    }

    public void error(Project project, String content) {
        if (project == null) {
            return;
        }
        final com.intellij.notification.Notification notification = POP.createNotification(unWrapMsg(content), NotificationType.ERROR);
        notification.notify(project);
    }

    public void warning(Project project, String content) {
        if (project == null) {
            return;
        }
        final com.intellij.notification.Notification notification = LOG.createNotification(unWrapMsg(content), NotificationType.WARNING);
        notification.notify(project);
    }

    private String unWrapMsg(String msg) {
        if (msg.startsWith("info-")) {
            return msg.replaceFirst("info-", "");
        }
        if (msg.startsWith("error-")) {
            return msg.replaceFirst("error-", "");
        }
        if (msg.startsWith("warning-")) {
            return msg.replaceFirst("warning-", "");
        }
        return msg;
    }
}
