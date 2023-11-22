package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8);

//        list.stream().parallel()
        list.parallelStream()
                .filter(x -> x % 2 ==0 )
                .forEach(x -> System.out.println(x + " " + Thread.currentThread().getName()));
    }
}