package com.example.example.example;

public interface MyList<T> {
    void add(T element);
    T get(int index);
    void remove(int index);
    int size();
    void display();
}

