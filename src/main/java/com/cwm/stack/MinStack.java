package com.cwm.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MinStack {

    private int[] array;

    private int size = 0;

    private int minValue = Integer.MAX_VALUE;

    public MinStack() {
        array = new int[size];
    }

    public void push(int value) {
        if (value < minValue)
            minValue = value;

        int[] newArray = new int[size + 1];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;

        array[size++] = value;
    }

    public int pop() {
        if (size == 0)
            throw new EmptyStackException();

        int top = array[size - 1];

        if (top == minValue) {
            minValue = Integer.MAX_VALUE;

            for (int i = 0; i < size - 1; i++)
                if (array[i] < minValue)
                    minValue = array[i];
        }

        size--;

        int[] newArray = new int[size];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;

        return top;
    }

    public int getMin() {
        return minValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
