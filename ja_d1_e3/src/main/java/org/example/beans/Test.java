package org.example.beans;

import org.example.annotations.Retry;

public class Test {

    @Retry(times = 3, exceptions = RuntimeException.class)
    public void test() {
        System.out.println("Test called");
        throw new RuntimeException();
    }
}
