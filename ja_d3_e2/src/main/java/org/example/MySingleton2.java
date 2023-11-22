package org.example;

public class MySingleton2 {

    private static MySingleton2 INSTANCE;

    static {
        synchronized (MySingleton2.class) {
            if (INSTANCE == null) {
                INSTANCE = new MySingleton2();
            }
        }
    }

    private MySingleton2() {}

    public static MySingleton2 getInstance() {
        return INSTANCE;
    }
}
