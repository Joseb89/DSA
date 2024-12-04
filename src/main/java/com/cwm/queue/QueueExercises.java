package com.cwm.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExercises {

    public void reverse(Queue<Integer> queue) {
        Queue<Integer> temp = new LinkedList<>();

        int[] array = new int[queue.size()];

        while (!queue.isEmpty())
            for (int i = 0; i < array.length; i++)
                array[i] = queue.remove();

        for (int i = array.length - 1; i >=0 ; i--)
            temp.add(array[i]);

        queue.addAll(temp);
    }

    public void reverseK(Queue<Integer> queue, int k) {
        Stack<Integer> stack = new Stack<>();

        while (k > 0) {
            stack.push(queue.remove());
            k--;
        }

        Queue<Integer> temp = new LinkedList<>();

        while (!stack.isEmpty())
            temp.add(stack.pop());

        while (!queue.isEmpty())
            temp.add(queue.remove());

        queue.addAll(temp);
    }
}
