package org.example.beans;

import org.example.annotations.FixedValue;
import org.example.annotations.RandomValue;

public class CustomNumber {

    @RandomValue
    private int value;

    @Override
    public String toString() {
        return "CustomNumber{" +
                "value=" + value +
                '}';
    }
}
