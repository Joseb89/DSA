package com.cwm.queue;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {

    private final Queue<Integer> q1 = new LinkedList<>();

    private final Queue<Integer> q2 = new LinkedList<>();

    private int size = 0;

    //O(1)
    public void push(int value) {
        q1.add(value);

        size++;
    }

    //O(n)
    public int pop() {
        int top = getTop();

        size--;

        return top;
    }

    //O(n)
    public int peek() {
        int top = getTop();
        q1.add(top);

        return top;
    }

    //O(1)
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    @Override
    public String toString() {
        return q1.toString();
    }

    private int getTop() {
        if (q1.isEmpty())
            throw new EmptyStackException();

        int count = size - 1;

        while (count > 0) {
            q2.add(q1.remove());
            count--;
        }

        int top = q1.remove();

        q1.addAll(q2);

        return top;
    }
}
