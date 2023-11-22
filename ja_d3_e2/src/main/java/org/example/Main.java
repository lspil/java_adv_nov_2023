package org.example;

public class Main {
    public static void main(String[] args) {
        MySingleton1 m = MySingleton1.getInstance();

        Cat cat1 = new Cat.Builder("Tom")
                .name("Tom")
                .build();

        Cat cat2 = new Cat.Builder("Tom")
                .name("Tom")
                .age(100)
                .build();

        Cat cat3 = new Cat.Builder("Tom")
                .name("Tom")
                .age(100)
                .color("blue")
                .build();


        Cat.Builder b = new Cat.Builder("Tom");
        System.out.println(b);
    }
}