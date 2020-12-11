package org.example.ex._1._3._3;

public class FixedCapacityStackOfIntegers {

    private final Integer[] array;
    private int N;

    public FixedCapacityStackOfIntegers(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        array = new Integer[n];
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
        int result = array[--N];
        array[N] = null;

        return result;
    }

}
