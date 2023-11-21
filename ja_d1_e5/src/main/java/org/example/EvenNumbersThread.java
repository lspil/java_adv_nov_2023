package org.example;

import java.time.Duration;

public class EvenNumbersThread extends Thread {

    @Override
    public void run() {
        for (int i = 2; i<=100; i+=2) {
            try {
                Thread.sleep(Duration.ofSeconds(1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }
}
