package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Rectangle> list1 = new ArrayList<Rectangle>();
        List<Rectangle> list2 = new ArrayList<>();

        List<?> list3;

        list3 = new ArrayList<Rectangle>();
        list3 = new ArrayList<Shape>();
        list3 = new ArrayList<String>();
        list3 = new ArrayList<Integer>();

        List<? extends Shape> list4 = new ArrayList<Shape>();
        List<? extends Shape> list5 = new ArrayList<Rectangle>();

        List<? super Rectangle> list6 = new ArrayList<Object>();
        List<? super Rectangle> list7 = new ArrayList<Shape>();
        List<? super Rectangle> list8 = new ArrayList<Rectangle>();

        list8.add(new Rectangle()); // ? nu reprezinta o prob pentru compilator aici

        MyLinkedList<Rectangle, Integer, String> list9 = new MyLinkedList<>();
    }

    public List<? super Rectangle> m1() {
        return null;
    }
}