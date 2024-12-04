package com.cwm.queue;

import java.util.Arrays;

public class MyArrayQueue {

    //enqueue
    //dequeue
    //isEmpty
    //isFull

    private int[] array;

    private int front = 0;

    private int rear = 0;

    private int size = 0;

    public MyArrayQueue() {
        array = new int[5];
    }

    public void enqueue(int value) {
        if (isFull())
            throw new StackOverflowError();

        array[rear] = value;
        rear = (rear + 1) % array.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        int top = array[front];

        array[front] = 0;
        front = (front + 1) % array.length;

        size--;

        return top;
    }

    public int peek() {
        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
