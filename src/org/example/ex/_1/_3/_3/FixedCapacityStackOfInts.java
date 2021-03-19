package org.example.ex._1._3._3;

import org.example.ex._1._3._7.IStack;

public class FixedCapacityStackOfInts {

    private final int[] array;
    private int N;

    public FixedCapacityStackOfInts(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        array = new int[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return array.length == N;
    }

    public int size() {
        return N;
    }

    public void push(int i) {
        array[N++] = i;
    }

    public int pop() {
        return array[--N];
    }

}
