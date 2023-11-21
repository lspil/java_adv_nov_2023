package org.example;

import java.util.List;

public class Exemplu7 {

    public static void main(String[] args) {
        var list =
                List.of(List.of(List.of(2,4),List.of(5,6)),
                        List.of(List.of(4,1,5), List.of(7,9)),
                        List.of(List.of(4,6),List.of(2,1)));

        list.stream()  // List<List<Integer>>
                .flatMap(x -> x.stream())  // List<Integer>
                .flatMap(x -> x.stream()) // Integer
                .forEach(x -> System.out.println(x));

    }
}
