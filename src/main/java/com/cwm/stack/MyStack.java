package com.cwm.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {

    private int[] array;

    private int size = 0;

    public MyStack() {
        array = new int[size];
    }

    public void push(int value) {
        int[] newArray = new int[size + 1];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;

        array[size++] = value;
    }

    public int pop() {
        if(isEmpty())
            throw new EmptyStackException();

        int top = array[size - 1];

        size--;

        int[] newArray = new int[size];

        System.arraycopy(array, 0, newArray, 0, size);

        array = newArray;

        return top;
    }

    public int peek() {
        if(isEmpty())
            throw new EmptyStackException();

        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
