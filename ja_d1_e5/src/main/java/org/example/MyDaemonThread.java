package org.example;

import java.time.Duration;

public class MyDaemonThread extends Thread {

    public MyDaemonThread() {
        setDaemon(true);
    }

    @Override
    public void run() {
        while(true) {
            // collect app metrics
            Runtime.getRuntime().totalMemory();
            try {
                Thread.sleep(Duration.ofSeconds(10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
