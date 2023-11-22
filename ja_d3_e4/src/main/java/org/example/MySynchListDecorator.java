package org.example;

import java.util.List;

public class MySynchListDecorator {

    private final List<Integer> list;

    public MySynchListDecorator(List<Integer> list) {
        this.list = list;
    }

    public synchronized Integer get(int index) {
        return list.get(index);
    }
}
