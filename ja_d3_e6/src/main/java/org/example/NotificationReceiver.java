package org.example;

import java.util.ArrayList;
import java.util.List;

public class NotificationReceiver {

    private List<NotificationListener> notificationListenerList;

    private NotificationReceiver() {
        this.notificationListenerList = new ArrayList<>();
    }

    private static final class SingletonHolder {
        private static final NotificationReceiver INSTANCE = new NotificationReceiver();
    }

    public static NotificationReceiver getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void notificationReceived(Notification notification) {
        notificationListenerList.forEach(
                n -> n.notificationReceived(notification)
        );
    }

    public void addNotificationListener(NotificationListener notificationListener) {
        notificationListenerList.add(notificationListener);
    }
}
