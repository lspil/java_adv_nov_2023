package org.example;

import java.util.List;

public class Exemplu2 {

    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6,7,8,9, 3, 5, 6, 4, 2);

//        list.stream()
//                .filter(x -> x % 2 == 0)
//                .forEach(x -> System.out.println(x));

//        list.stream()
//                .filter(x -> x % 2 == 0)
//                .map(x -> x * 2)
//                .forEach(x -> System.out.println(x));

//        list.stream()
//                .filter(x -> x % 2 == 0)
//                .map(x -> x * 2)
//                .filter(x -> x < 10)
//                .forEach(x -> System.out.println(x));

//        list.stream()
//                .distinct()
//                .filter(x -> x % 2 == 0)
//                .forEach(x -> System.out.println(x));

//        int sum =
//            list.stream()
//                    .filter(x -> x % 2 == 0)
//                    .distinct()
//                    .reduce(0, (x,y) -> x + y);
//        System.out.println(sum);

//        int sum =
//            list.stream()
//                    .filter(x -> x % 2 == 0)
//                    .distinct()
//                    .mapToInt(x -> x) // mapToLong(), mapToDouble()
//                    .sum();
//
//        System.out.println(sum);

        // Stream, IntStream, LongStream, DoubleStream

        long count =
                list.stream()
                        .filter(x -> x % 2 == 0)
                        .distinct()
                        .count();

        System.out.println(count);
    }
}
