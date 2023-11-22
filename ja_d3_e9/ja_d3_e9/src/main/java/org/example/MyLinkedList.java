package org.example;

public class MyLinkedList<T extends Shape, G, K> {

    Node root;
    
    public class Node<T> {
        T value;
        Node next;


    }
}
