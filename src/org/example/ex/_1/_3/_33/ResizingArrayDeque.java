package org.example.ex._1._3._33;

import java.util.Iterator;

public final class ResizingArrayDeque<T> implements Iterable<T> {

    private final ResizingArray<T> array = new ResizingArray<>();

    public void pushLeft(T item) {
        array.addFirst(item);
    }

    public void pushRight(T item) {
        array.addLast(item);
    }

    public T popLeft() {
        return array.remove(0);
    }

    public T popRight() {
        return array.remove(array.size() - 1);
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return new ResizingArrayDequeIterator();
    }

    private class ResizingArrayDequeIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < array.size();
        }

        @Override
        public T next() {
            return array.get(currentIndex++);
        }
    }
}
