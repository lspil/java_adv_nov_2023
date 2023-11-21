package org.example;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Main {
    public static void main(String[] args) {

        // Runnable, Callable<T>

//        Thread t1 = Thread.ofPlatform()
//                .unstarted(new OddNumberRunnable());
//
//        t1.start();

        // CPU -> Cores -> Thread (OS)
        // Java (JVM) -> Thread (OS)

        EvenNumbersThread t = new EvenNumbersThread();
        t.start();

//        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

//        for (int i=0; i <= 1_000_000; i++) {
//            service.submit(
//                    () -> {
//                        try {
//                            Thread.sleep(Duration.ofSeconds(1));
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//            );
//        }
    }
}