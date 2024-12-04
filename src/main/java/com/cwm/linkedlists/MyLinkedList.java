package com.cwm.linkedlists;

import java.util.NoSuchElementException;

public class MyLinkedList {

    private Node first;
    private Node last;

    private int size = 0;

    public void addLast(int value) {
        Node node = new Node(value);

        if (isFirstNull())
            first = last = node;

        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int value) {
        Node node = new Node(value);

        if (isFirstNull())
            first = last = node;

        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(int value) {
        if (isFirstNull())
            throw new IllegalStateException();

        int index = 0;

        Node current = first;

        while (current != null) {
            if (current.value == value)
                return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public void removeFirst() {
        if (isFirstNull())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;

        else {
            Node second = first.next;

            first.next = null;

            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isFirstNull())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;

        else {
            Node current = first;

            // Get previous from last
            while (current != null) {
                if (current.next == last) break;

                current = current.next;
            }

            last = current;

            current.next = null;
        }

        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];

        int index = 0;

        Node current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        if (isFirstNull()) return;

        Node previous = first;
        Node current = first.next;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromEnd(int k) {
        if (isFirstNull())
            throw new IllegalStateException();

        Node a = first;
        Node b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;

            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;            b = b.next;
        }

        return a.value;
    }

    public void printMiddle() {
        Node a = first;
        Node b = first;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + ", " + a.next.value);
    }

    private boolean isFirstNull() {
        return first == null;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
