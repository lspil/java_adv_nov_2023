package org.example;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(4);

        // divide et impera recursiv multithreaded

        // multe taskuri --> fiecare subgrup de taskuri este tratat de un thread separat.

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,32,34,1,2,3,4,5,6,7,8,9);

        // RecursiveTask<T>, RecursiveAction

        var result = pool.invoke(new ListSumRecursiveTask(list));

        System.out.println(result);
        System.out.println(list.stream().mapToInt(n -> n).sum());
    }
}