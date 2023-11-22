package org.example;

import java.util.List;

public class ListLoggingDecorator {

    private final List<Integer> list;

    public ListLoggingDecorator(List<Integer> list) {
        this.list = list;
    }

    public Integer get(int index) {
        System.out.println("Get was called for index " + index);
        return list.get(index);
    }
}
