package org.example;

import org.example.annotations.FixedValue;
import org.example.annotations.RandomValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {

        try {

            Class klass = Class.forName("org.example.beans.CustomNumber");
            Constructor constructor = klass.getDeclaredConstructor();

            Object target = constructor.newInstance();

            Field[] fields = klass.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                if (f.isAnnotationPresent(FixedValue.class)) {
                    FixedValue a = f.getDeclaredAnnotation(FixedValue.class);
                    int value = a.value();
                    f.setInt(target, value);
                }
                if (f.isAnnotationPresent(RandomValue.class)) {
                    SecureRandom r = new SecureRandom();
                    f.setInt(target, r.nextInt());
                }
            }

            System.out.println(target);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}