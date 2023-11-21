package org.example;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Exemplu2 {

    public static void main(String[] args) {

//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(4);

        try {
            /**
             * schedule -> porneste un task dupa un delay dat
             * scheduleAtFixedRate -> porneste un task dupa un delay dat si il executa o data la un interval specificat
             * scheduleWithFixedDelay -> porneste un task dupa un delay dat si il executa cu un delay specificat
             */
            service.scheduleAtFixedRate(() -> System.out.println(":)"), 1, 1, TimeUnit.SECONDS);

            Thread.sleep(Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
