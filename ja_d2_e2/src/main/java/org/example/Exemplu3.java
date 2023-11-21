package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exemplu3 {

    private static List<Future<String>> futureResults = new ArrayList<>();

    public static void main(String[] args) {

        var executor = Executors.newSingleThreadExecutor();

        Runnable r = () -> {

        };

        Callable<String> c = () -> {
            if (true) {
                throw new RuntimeException();
            }
            return "Hello";
        };

        // Future

        futureResults.add(executor.submit(c));

        ///

//        try {
//            String result = futureResult.get();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            System.out.println(e.getCause());
//        }




    }
}
