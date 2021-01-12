package org.example.ex._1._3._31;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> first;
    private int N;

    public void insertFirst(T value) {
        if (N == 0) {
            first = new DoubleNode<>(value, null, null);
        } else {
            final DoubleNode<T> newFirst = new DoubleNode<>(value, null, first);
            first.prev = newFirst;
            first = newFirst;
        }

        N++;

    }

    public void insertLast(T value) {
        if (N == 0) {
            first = new DoubleNode<>(value, null, null);
        } else {
            DoubleNode<T> current = first;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new DoubleNode<>(value, current, null);
        }

        N++;
    }

    public void insertBefore(int index, T value) {
        if (index < 0 || index >= N) {
            return;
        }

        if (index == 0) {
            insertFirst(value);
        } else {
            DoubleNode<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            DoubleNode<T> insertedBefore = new DoubleNode<>(value, current.prev, current);
            if (current.prev != null) {
                current.prev.next = insertedBefore;
            }
            current.prev = insertedBefore;
            N++;
        }
    }

    public void insertAfter(int index, T value) {
        if (index < 0 || index >= N) {
            return;
        }

        if (index == size() - 1) {
            insertLast(value);
        } else {
            DoubleNode<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.next = new DoubleNode<>(value, current, current.next);
            N++;
        }
    }

    public T removeFirst() {
        if (N == 0) {
            return null;
        } else {
            final T value = first.value;
            first = first.next;
            if (first != null) {
                first.prev = null;
            }

            N--;
            return value;
        }
    }

    public T removeLast() {
        if (N == 0) {
            return null;
        } else {
            DoubleNode<T> current = first;
            while (current.next != null) {
                current = current.next;
            }

            final T value = current.value;
            if (current.prev != null) {
                current.prev.next = null;
            }
            N--;

            return value;
        }
    }

    public T remove(int index) {
        if (index < 0 || index >= N) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        } else if (index == N - 1) {
            return removeLast();
        } else {
            DoubleNode<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            N--;

            return current.value;
        }
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<T> {
        private DoubleNode<T> current = first;

        @Override
        public boolean hasNext() {
            return current == null;
        }

        @Override
        public T next() {
            final T value = current.value;

            current = current.next;

            return value;
        }
    }
}
