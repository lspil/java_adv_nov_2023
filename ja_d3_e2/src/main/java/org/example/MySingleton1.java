package org.example;

public class MySingleton1 {

    private static MySingleton1 INSTANCE;

    private MySingleton1() {}

    public static MySingleton1 getInstance() {
        if (INSTANCE == null) {
            synchronized (MySingleton1.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MySingleton1();
                }
            }
        }
        return INSTANCE;
    }
}
