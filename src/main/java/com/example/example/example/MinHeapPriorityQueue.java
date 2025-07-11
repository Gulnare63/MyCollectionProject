package com.example.example.example;


public class MinHeapPriorityQueue<T extends Comparable<T>> implements MyPriorityQueque<T> {
    private final T[] heap;
    private int size;










    public MinHeapPriorityQueue(int capacity) {
        heap = (T[]) new Comparable[capacity];
        size = 0;
    }

    @Override
    public void add(T value) {
        if (size == heap.length) {
            throw new IllegalStateException("Queue is full");
        }

        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    @Override
    public T poll() {
        if (size == 0) return null;

        T result = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);
        return result;
    }

    @Override
    public T peek() {
        if (size == 0) return null;
        return heap[0];
    }

    // Helper methods
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[index].compareTo(heap[parent]) < 0) {
                swap(index, parent);
                index = parent;
            } else break;
        }
    }

    private void heapifyDown(int index) {
        while (index < size) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < size && heap[left].compareTo(heap[smallest]) < 0) smallest = left;
            if (right < size && heap[right].compareTo(heap[smallest]) < 0) smallest = right;

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else break;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}

