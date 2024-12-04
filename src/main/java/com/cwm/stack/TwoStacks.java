package com.cwm.stack;

import java.util.Arrays;

public class TwoStacks {

    private final int[][] array;

    private int count1 = 0;

    private int count2 = 0;

    public TwoStacks() {
        array = new int[2][count1];
    }

    public void push1(int value) {
        int[] newArray = new int [count1 + 1];

        System.arraycopy(array[0], 0, newArray, 0, count1);

        array[0] = newArray;

        array[0][count1++] = value;
    }

    public void push2(int value) {
        int[] newArray = new int[count2 + 1];

        System.arraycopy(array[1], 0, newArray, 0, count2);

        array[1] = newArray;

        array[1][count2++] = value;
    }

    public int pop1() {
        int top = array[0][count1 - 1];

        count1--;

        int[] newArray = new int[count1];

        System.arraycopy(array[0], 0, newArray, 0, count1);

        array[0] = newArray;

        return top;
    }

    public int pop2() {
        int top = array[1][count2 - 1];

        count2--;

        int[] newArray = new int[count2];

        System.arraycopy(array[1], 0, newArray, 0, count2);

        array[1] = newArray;

        return top;
    }

    public boolean isEmpty1() {
        return count1 == 0;
    }

    public boolean isEmpty2() {
        return count2 == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array[0]) + Arrays.toString(array[1]);
    }
}
