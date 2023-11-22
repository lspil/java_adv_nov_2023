package org.example;

public class Main {
    public static void main(String[] args) {

        NotificationReceiver n = NotificationReceiver.getInstance();

        NotificationListener n1 = NotificationListener.getNotificationListener(NotificationListener.Type.VIBRATE);
        NotificationListener n2 = NotificationListener.getNotificationListener(NotificationListener.Type.POPUP);

        n.addNotificationListener(n1);
        n.addNotificationListener(n2);

    }
}