package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exemplu4 {

    public static void main(String[] args) {
//        List<String> list = List.of("AAA", "BB", "CCCC", "DD", "EEEEEE");

//        Map<Boolean, List<String>> map =
//            list.stream()
//                    .collect(
//                            Collectors.partitioningBy(s -> s.length() % 2 == 0));

//        Map<Boolean, String> map =
//                list.stream()
//                        .collect(
//                                Collectors.partitioningBy(s -> s.length() % 2 == 0,
//                                        Collectors.joining()));

//        Map<Boolean, Long> map =
//                list.stream()
//                        .collect(
//                                Collectors.partitioningBy(s -> s.length() % 2 == 0,
//                                        Collectors.counting()));

        List<String> list = List.of("HELLO", "WORLD", "BANANA", "CHERRY");
        Map<Boolean, String> map =
                list.stream()
                        .collect(
                                Collectors.partitioningBy(s -> s.length() % 2 == 0,
                                        Collectors.mapping(x -> new StringBuilder(x).reverse(),
                                                Collectors.joining())));

        System.out.println(map);

    }
}
