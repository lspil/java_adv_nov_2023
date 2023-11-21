package org.example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        /**
         *
         * Sempahore
         * ReadWriteLock
         * CyclicBarrier
         *
         */

        Semaphore semaphore = new Semaphore(10);

        try {
            semaphore.acquire();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }

        // =============================================

//        CyclicBarrier barrier = new CyclicBarrier(5);
//        barrier.await();

    }
}