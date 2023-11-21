package org.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exemplu4 {

    public static void main(String[] args) {

        Runnable r = () -> {
            throw new NullPointerException();
        };

        var executor = Executors.newSingleThreadExecutor();

        Future<?> futureResult = executor.submit(r);

        try {
            futureResult.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }

    }
}
