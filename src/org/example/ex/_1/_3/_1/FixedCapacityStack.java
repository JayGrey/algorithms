package org.example.ex._1._3._1;

import org.example.ex._1._3._7.IStack;

public class FixedCapacityStack<T> implements IStack<T> {
    private final T[] array;
    private int N;

    public FixedCapacityStack(int n) {
        array = createArray(n);
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int arrayLength) {
        return (T[]) new Object[arrayLength];
    }

    @Override
    public void push(T value) {
        array[N++] = value;
    }

    @Override
    public T pop() {
        final T value = array[--N];
        array[N] = null;
        return value;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return array.length == N;
    }

    @Override
    public int size() {
        return N;
    }
}
