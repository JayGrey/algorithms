package org.example.ex._1._3._33;

import java.util.Iterator;

public class ResizingArrayDeque<T> implements Iterable<T> {

    private static final int NOMINAL_ARRAY_SIZE = 8;

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[NOMINAL_ARRAY_SIZE];

    private int N = 0;

    public void pushLeft(T item) {
        if (N + 1 >= array.length) {
            increaseArray();
        }

        System.arraycopy(array, 0, array, 1, N);
        array[0] = item;
        N++;
    }

    public void pushRight(T item) {
        if (N >= array.length) {
            increaseArray();
        }

        array[N++] = item;
    }

    public T popLeft() {
        if (N == 0) {
            return null;
        }

        final T value = array[0];
        System.arraycopy(array, 1, array, 0, N);
        array[N - 1] = null;
        N--;

        return value;
    }

    public T popRight() {
        if (N == 0) {
            return null;
        }
        final T value = array[N - 1];
        array[N - 1] = null;
        N--;
        return value;
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
    public Iterator<T> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < N;
        }

        @Override
        public T next() {
            return array[currentIndex++];
        }
    }
}
