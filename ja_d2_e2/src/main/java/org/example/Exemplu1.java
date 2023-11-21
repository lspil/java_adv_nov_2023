package org.example;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exemplu1 {

    public static void main(String[] args) {
        // Runnable , Callable

        // Executor, ExecutorService, ScheduledExecutorService

        int thread = Runtime.getRuntime().availableProcessors();
//        ExecutorService service = Executors.newFixedThreadPool(
//               thread
//        );

//        ExecutorService service = Executors.newCachedThreadPool();

        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            for (int i=0; i<50; i++) {
                service.submit(() -> {
                    try {
                        System.out.println(":) " + Thread.currentThread().getName());
                        Thread.sleep(Duration.ofSeconds(1));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            service.shutdown();
        }

    }

}