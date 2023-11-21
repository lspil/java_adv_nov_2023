package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Exemplu8 {

    public static void main(String[] args) {
        Optional<Integer> o = doSmth3();

        Integer x = o.orElseThrow(() -> new RuntimeException());
        
        // ...
    }

    public static List<String> doSmth1() {

        return Collections.emptyList();
    }

    public static Stream<String> doSmth2() {

        return Stream.empty();
    }

    public static Optional<Integer> doSmth3() {

        return Optional.empty();
    }
}
