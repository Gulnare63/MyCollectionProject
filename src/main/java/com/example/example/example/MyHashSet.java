package com.example.example.example;


public class MyHashSet<T> implements MySet<T> {
    private static final int CAPACITY = 16;
    private Node<T>[] buckets;
    public MyHashSet() {
        buckets = new Node[CAPACITY];
    }
    private static class Node<T> {
        T value;
        Node<T> next;
        Node(T value) {
            this.value = value;
        }
    }
    @Override
    public boolean add(T value) {
        int index = getBucketIndex(value);
        Node<T> current = buckets[index];

        while (current != null) {
            if ((current.value == null && value == null) ||
                    (current.value != null && current.value.equals(value))) {
                return false; // Təkrar element → əlavə olunmur
            }
            current = current.next;
        }

        // Yeni node əlavə et
        Node<T> newNode = new Node<>(value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        return true;
    }

    private int getBucketIndex(T value) {
        return (value == null) ? 0 : Math.abs(value.hashCode()) % CAPACITY;
    }

}

