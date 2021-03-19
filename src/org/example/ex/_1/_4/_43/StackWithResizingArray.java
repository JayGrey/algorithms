package org.example.ex._1._4._43;

import org.example.ex._1._3._33.ResizingArray;
import org.example.ex._1._3._7.IStack;

public class StackWithResizingArray<T> implements IStack<T> {
    private final ResizingArray<T> array = new ResizingArray<>();
    private int N = 0;

    @Override
    public void push(T value) {
        array.addLast(value);
        N++;
    }

    @Override
    public T pop() {
        final T value = array.get(--N);
        array.set(N, null);

        return value;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }
}
