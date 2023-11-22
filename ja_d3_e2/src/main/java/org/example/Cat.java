package org.example;

public class Cat {

    private String name;
    private int age;
    private String color;

    public static class Builder {
        private Cat cat = new Cat();

        public Builder(String name) {
            cat.name = name;
        }

        public Builder name(String name) {
            cat.name = name;
            return this;
        }

        public Builder age(int age) {
            cat.age = age;
            return this;
        }

        public Builder color(String color) {
            cat.color = color;
            return this;
        }

        public Cat build() {
            return cat;
        }
    }
}
