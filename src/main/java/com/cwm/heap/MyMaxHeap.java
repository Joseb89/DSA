package com.cwm.heap;

import java.util.Arrays;

public abstract class MyMaxHeap {

    public static void heapify(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapifyArray(array, i);
    }

    public static int kthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        MyHeap heap = new MyHeap();

        for (int i : array)
            heap.insert(i);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        System.out.println(heap);

        return heap.getRoot();
    }

    private static void heapifyArray(int[] array, int index) {
        int largerIndex = index;

        int leftIndex = (index * 2) + 1;

        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        int rightIndex = (index * 2) + 2;

        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        int temp = array[index];
        array[index] = array[largerIndex];
        array[largerIndex] = temp;

        heapifyArray(array, largerIndex);

    }
}
