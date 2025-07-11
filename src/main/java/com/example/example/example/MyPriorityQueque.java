package com.example.example.example;

    public interface MyPriorityQueque<T extends Comparable<T>> {
        void add(T element);
        T poll();
        T peek();

    }


