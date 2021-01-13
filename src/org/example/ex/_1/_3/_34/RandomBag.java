package org.example.ex._1._3._34;

import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._3._33.ResizingArrayDeque;

import java.util.Iterator;

public class RandomBag<T> implements Iterable<T> {
    private final ResizingArrayDeque<T> arrayDeque = new ResizingArrayDeque<>();

    public void add(T item) {
        arrayDeque.pushRight(item);
    }

    public int size() {
        return arrayDeque.size();
    }

    public boolean isEmpty() {
        return arrayDeque.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<T> {
        @SuppressWarnings("unchecked")
        private final T[] array = (T[]) new Object[arrayDeque.size()];
        private int index = 0;

        public RandomBagIterator() {
            int i = 0;
            for (T item : arrayDeque) {
                array[i++] = item;
            }

            // shuffle array
            int N = array.length;
            for (int j = 0; j < N; j++) {
                int r = j + StdRandom.uniform(N - j);
                final T temp = array[j];
                array[j] = array[r];
                array[r] = temp;
            }
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            return array[index++];
        }
    }
}
