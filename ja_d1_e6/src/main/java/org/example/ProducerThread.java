package org.example;

import java.util.Random;

public class ProducerThread extends Thread {

    public ProducerThread(String name) {
        super(name);
    }

    public void run() {
        try {

            while (true) {
                synchronized (Main.container) {
                    if (Main.container.size() < 100) {
                        int x = new Random().nextInt();
                        Main.container.add(x);
                        System.out.println("Producer " + this.getName() + " added value " + x);
                        Main.container.notifyAll();
                    } else {
                        Main.container.wait();
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
