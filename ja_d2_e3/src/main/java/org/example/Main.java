package org.example;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {

        AtomicInteger a1 = new AtomicInteger();
        AtomicBoolean a2 = new AtomicBoolean();

        a1.set(10);
        int x= a1.addAndGet(20);


        int sum = 0;

        List<Integer> list = List.of(2,5,6,4,2,3);
        sum = list.stream()
                .mapToInt(n -> n)
                .sum();

    }
}