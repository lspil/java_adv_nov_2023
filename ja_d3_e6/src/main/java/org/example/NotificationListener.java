package org.example;

public interface NotificationListener {

    void notificationReceived(Notification notification);

    static NotificationListener getNotificationListener(Type type) {
        return switch (type) {
            case VIBRATE -> new VibrateManager();
            case POPUP -> new DisplayPopup();
        };
    }

    enum Type {
        VIBRATE, POPUP
    }
}
