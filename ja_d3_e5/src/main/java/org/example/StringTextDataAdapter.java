package org.example;

public class StringTextDataAdapter implements TextData {

    private final String adaptee;

    public StringTextDataAdapter(String adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int size() {
        return adaptee.length();
    }
}
