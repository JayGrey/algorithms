package org.example.ex._1._3._1;

public class FixedCapacityStackOfStrings {
    private final String[] array;
    private int N;

    public FixedCapacityStackOfStrings(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        array = new String[n];
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

    public void push(String s) {
        array[N++] = s;
    }

    public String pop() {
        String result = array[--N];
        array[N] = null;

        return result;
    }
}
