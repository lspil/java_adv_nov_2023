package org.example;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        a();
    }

    static void a() {
        var random = new Random();
        while (true) {
            for (int i = 0 ; i< 1000; i++) {
                list.add(random.nextInt());
            }

            list.clear();
        }
    }
}