package org.example.ex._1._3._33;

import java.util.Iterator;
import java.util.StringJoiner;

public final class ResizingArray<T> implements Iterable<T> {

    private static final int INITIAL_ARRAY_SIZE = 8;

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[INITIAL_ARRAY_SIZE];

    private int N;

    public void addFirst(T item) {
        if (N + 1 >= array.length) {
            increaseArray();
        }

        System.arraycopy(array, 0, array, 1, N);
        array[0] = item;
        N++;
    }

    public void addLast(T item) {
        if (N >= array.length) {
            increaseArray();
        }

        array[N++] = item;
    }

    public T remove(int index) {
        if (index >= N || index < 0) {
            return null;
        }

        final T oldValue = array[index];

        if (index != N - 1) {
            System.arraycopy(array, index + 1, array, index, N - index - 1);
        }

        array[--N] = null;

        return oldValue;
    }

    public T get(int index) {
        if (index >= N) {
            return null;
        }

        return array[index];
    }

    public T set(int index, T newValue) {
        if (index >= N) {
            return null;
        }

        final T oldValue = array[index];
        array[index] = newValue;

        return oldValue;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * increase array size twice
     */
    private void increaseArray() {
        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[array.length * 2];

        System.arraycopy(array, 0, tempArray, 0, N);
        array = tempArray;
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (int i = 0; i < N; i++) {
            joiner.add(array[i].toString());
        }
        return joiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayIterator();
    }

    private class ResizingArrayIterator implements Iterator<T> {
        private int currentPos = 0;

        @Override
        public boolean hasNext() {
            return currentPos < N;
        }

        @Override
        public T next() {
            return array[currentPos++];
        }
    }
}
