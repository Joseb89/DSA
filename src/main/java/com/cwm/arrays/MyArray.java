package com.cwm.arrays;

public class MyArray {

    private int[] array;

    private int position = 0;

    public MyArray(int size) {
        array = new int[size];
    }

    public void insert(int value) {
        if (isArrayFull()) {
            int[] newArray = new int[array.length + 1];

            System.arraycopy(array, 0, newArray, 0, position);

            array = newArray;
        }

        array[position++] = value;
    }

    public int indexOf(int value) {
        for (int i = 0; i < position; i++)
            if (array[i] == value)
                return i;

        return -1;
    }

    public void removeAt(int index) {
        if (isIndexValid(index))
            throw new IllegalArgumentException();

        for (int i = index; i < position - 1; i++)
            array[i] = array[i + 1];

        position--;

        int[] newArray = new int[position];

        System.arraycopy(array, 0, newArray, 0, position);

        array = newArray;
    }

    public int max() {
        int max = 0;

        for (int i = 0; i < position; i++)
            if (array[i] > max)
                max = array[i];

        return max;
    }

    public int[] intersect(int[] other) {
        int count = 0;

        int[] intersection = new int[count];

        for (int i : array) {
            for (int j : other) {
                if (i == j) {
                    int[] newArray = new int[count + 1];

                    System.arraycopy(intersection, 0, newArray, 0, count);

                    intersection = newArray;

                    intersection[count++] = i;
                }
            }
        }

        return intersection;
    }

    public void reverse() {
        int[] newArray = new int[position];

        int count = 0;

        for (int i = position - 1; i >= 0; i--)
            newArray[count++] = array[i];

        array = newArray;
    }

    public void insertAt(int value, int index) {
        if (isIndexValid(index) || isArrayFull())
            throw new IllegalArgumentException();

        int current = array[index];

        for (int i = index; i < position; i++) {
            int nextValue = array[i + 1];

            array[i + 1] = current;

            current = nextValue;
        }

        array[index] = value;
    }

    public void print() {
        for (int i = 0; i < position; i++)
            System.out.println(array[i]);
    }

    private boolean isArrayFull() {
        return position == array.length;
    }

    private boolean isIndexValid(int index) {
        return index < 0 || index >= position;
    }
}
