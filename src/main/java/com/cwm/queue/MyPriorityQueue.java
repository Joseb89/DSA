package com.cwm.queue;

import java.util.Arrays;

public class MyPriorityQueue {

    private int[] array;

    private int count = 0;

    public MyPriorityQueue(int size) {
        array = new int[size];
    }

    public void add(int value) {
        if (isEmpty()) {
            array[0] = value;
            count++;

            return;
        }

        if (isFull()) {
            int[] newArray = new int[count * 2];

            System.arraycopy(array, 0, newArray, 0, count);

            array = newArray;
        }

        for (int i = count - 1; i >= 0; i--) {
            if (value < array[i])
                array[i + 1] = array[i];

            else {
                array[i + 1] = value;

                count++;

                return;
            }
        }

        array[0] = value;

        count++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int top = array[0];

        int[] newArray = new int[array.length];

        System.arraycopy(array, 1, newArray, 0, count - 1);

        array = newArray;

        count--;

        return top;
    }

    public int peek() {
        return array[0];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
