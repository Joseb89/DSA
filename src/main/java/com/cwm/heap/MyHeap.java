package com.cwm.heap;

import java.util.Arrays;

public class MyHeap {

    private int[] heap;

    private int size = 0;

    public MyHeap() {
        heap = new int[size];
    }

    public void insert(int value) {
        int[] newHeap = new int[size + 1];

        System.arraycopy(heap, 0, newHeap, 0, size);

        heap = newHeap;

        heap[size++] = value;

        int index = size - 1;

        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int remove() {
        if (size == 0)
            throw new IllegalStateException("Heap is empty");

        if (size == 1) {
            heap = new int[0];

            return 0;
        }

        int[] newHeap = new int[size - 1];

        System.arraycopy(heap, 1, newHeap, 0, size - 1);

        heap = newHeap;

        size--;

        int root = heap[0];

        int index = 0;

        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);

            swap(index, largerChildIndex);

            index = largerChildIndex;
        }

        return root;
    }

    public int getRoot() {
        return heap[0];
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return leftChildIndex(index);
    }

    private int rightChild(int index) {
        return rightChildIndex(index);
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) > size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int largerChildIndex(int index) {
        if (hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) :
                rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        if (hasLeftChild(index))
            return true;

        boolean isValid = heap[index] >= leftChild(index);

        if (hasRightChild(index))
            isValid &= heap[index] >= rightChild(index);

        return isValid;
    }

    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}
