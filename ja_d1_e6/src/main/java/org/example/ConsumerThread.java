package org.example;

public class ConsumerThread extends Thread {

    public ConsumerThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (Main.container) {
                    if (!Main.container.isEmpty()) {
                        int x = Main.container.get(0);
                        Main.container.remove(0);
                        System.out.println("Consumer " + this.getName() + " consumed value " + x);
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
