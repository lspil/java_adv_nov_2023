package org.example;

import org.example.annotations.Retry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        // Logica unei biblioteci care face retry de un numar de ori dat, unei metode atunci cand aceasta
        // arunca o exceptie cunoscuta

        // @Retry(times = 3, exceptions = {RuntimeException.class, NullPointerException.class})

        /*
        1. Scriem adnorarea
        2. Cream o clasa Test cu o metoda test() care arunca aleator o exceptie.
        3. Implementam in Main logica de retry care daca se arunca o exceptie decalrata
        se face retry max given numar de ori.
         */

        try {
            Class klass = Class.forName("org.example.beans.Test");

            Constructor constructor = klass.getDeclaredConstructor();
            Object target = constructor.newInstance();

            Method m = klass.getDeclaredMethod("test");


            try {
                m.invoke(target);
            } catch (Exception e) {
                if (m.isAnnotationPresent(Retry.class)) {
                    Retry retry = m.getAnnotation(Retry.class);

                    int numberOfTimes = retry.times();
                    Class[] exceptions = retry.exceptions();

                    boolean failed = true;
                    while (numberOfTimes > 0 && failed) {
                        for (Class ex : exceptions) {
                            if (ex.equals(e.getCause().getClass())) {
                                try {
                                    numberOfTimes--;
                                    m.invoke(target);
                                    failed = false;
                                } catch (Exception exp) {
                                    failed = true;
                                    e = exp;
                                }
                            }
                        }
                    }
                    if (failed) {
                        throw e;
                    }
                } else {
                    throw e;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}