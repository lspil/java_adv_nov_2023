package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Exemplu6 {

    public static void main(String[] args) {

        List<List<Integer>> list =
                List.of(List.of(2,4,5,6),
                        List.of(4,1,5,7,9),
                        List.of(4,6,2,1));

//        int sum =
//            list.stream()
//                    .flatMap(x -> x.stream())
//                    .distinct()
//                    .mapToInt(x -> x)
//                    .sum();
//
//        System.out.println(sum);

        List<Integer> res =
                list.stream()
                        .flatMap(x -> x.stream())
                        .distinct()
                        .collect(Collectors.toList());

        System.out.println(res);
    }
}
