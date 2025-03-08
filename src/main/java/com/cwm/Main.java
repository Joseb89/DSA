package com.cwm;

import com.cwm.heap.MyHeap;
import com.cwm.heap.MyMaxHeap;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();

        myHeap.insert(10);
        myHeap.insert(5);
        myHeap.insert(17);
        myHeap.insert(4);
        myHeap.insert(22);

        System.out.println(myHeap);

        myHeap.remove();

        System.out.println(myHeap);

        int[] numbers = {5, 3, 8, 4, 1, 2};

        MyMaxHeap.heapify(numbers);

        System.out.println(Arrays.toString(numbers));

        System.out.println(MyMaxHeap.kthLargest(numbers, 2));
    }
}