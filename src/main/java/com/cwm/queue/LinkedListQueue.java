package com.cwm.queue;

import java.util.Arrays;

public class LinkedListQueue {

    private Node head;
    private Node tail;

    private int size = 0;

    //0(1)
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty())
            head = tail = newNode;

        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    //O(n)
    public int dequeue() {
        int top = head.value;

        Node next = head.next;

        head.next = null;

        head = next;

        size--;

        return top;
    }

    //O(1)
    public int peek() {
        return head.value;
    }

    //O(1)
    public int size() {
        return size;
    }

    //O(1)
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    private int[] toArray() {
        Node current = head;

        int[] array = new int[size];

       for (int i = 0; i < size; i++) {
           array[i] = current.value;
           current = current.next;
       }

       return array;
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
