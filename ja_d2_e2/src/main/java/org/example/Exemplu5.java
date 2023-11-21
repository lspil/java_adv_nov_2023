package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Exemplu5 {


    public static void main(String[] args) {


    }

    public static void calculateInterestRate() {
        // Future <- send async HTTP call to new rates
        // Future <- send async HTTP call to new currency rates

        // calculezi unele si altele

        // get f1, f2

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "HELLO");

        future.thenAccept(result -> {
            System.out.println(result);
        }).exceptionally(
                e -> {
                    return null;
                }
        );

    }
}
