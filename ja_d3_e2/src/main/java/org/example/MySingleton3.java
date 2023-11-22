package org.example;

public class MySingleton3 {

    private static final class SingletonHolder {
        private static MySingleton3 INSTANCE = new MySingleton3();
    }

    public static MySingleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
