package com.example.example.example;

public class LinkedList<T> implements MyList<T> {

    private int size = 0;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        Node<T> prev;
        Node<T> next;
        T item;

        Node(Node<T> prev, Node<T> next, T item) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(tail, null, element);
        if (tail == null) {
            head = newNode; // ilk element
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Yanlış indeks: " + index);
        }
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.item;
    }
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Yanlış indeks: " + index);
        }
        Node<T> toRemove;

        if (index == 0) {
            toRemove = head;
            head = head.next;
           if (head != null) head.prev = null;
           else tail = null;
        } else if (index == size - 1) {
            toRemove = tail;
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            toRemove = head;
            for (int i = 0; i < index; i++) {
                toRemove = toRemove.next;
            }
            toRemove.prev.next = toRemove.next;
            toRemove.next.prev = toRemove.prev;
        }
        size--;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void display() {
        System.out.print("LinkedList: ");
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }
        System.out.println();
    }

}
