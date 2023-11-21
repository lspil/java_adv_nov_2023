package org.example.beans;

public class Cat {

    private String name;

    private Cat() {
        System.out.println("A cat has been created");
    }

    private void sayMeow() {
        System.out.println("Meow! My name is " + name);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
