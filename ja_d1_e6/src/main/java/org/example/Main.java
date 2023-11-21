package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static List<Integer> container = new ArrayList<>();

    public static void main(String[] args) {
        new ProducerThread("P1").start();
        new ProducerThread("P2").start();
        new ProducerThread("P3").start();

        new ConsumerThread("C1").start();
        new ConsumerThread("C2").start();
        new ConsumerThread("C3").start();

        List<Integer> list = new ArrayList<>();

        ContainerSynchManager manager =
                new ContainerSynchManager(list);


    }
}