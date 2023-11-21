package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exemplu5 {

    public static void main(String[] args) {

        List<String> list = List.of("HELLO", "WORLD", "BANANA", "CHERRY", "EGGS");

        Map<Integer, Double> result =
            list.stream()
                    .collect(Collectors.groupingBy(x -> x.length(),
                            Collectors.mapping(x -> x.length(),
                                    Collectors.averagingInt(x -> x))));

        System.out.println(result);

    }
}
