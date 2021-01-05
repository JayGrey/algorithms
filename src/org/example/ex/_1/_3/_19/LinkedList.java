package org.example.ex._1._3._19;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private int N;

    public void add(T element) {
        if (first == null) {
            first = new Node<>(element, null);
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }

            current.next = new Node<>(element, null);
        }
        N++;
    }

    public T removeLast() {
        if (first == null) {
            return null;
        }

        if (first.next == null) {
            final T value = first.value;
            first = null;
            N--;
            return value;
        } else {
            Node<T> prev = first;
            Node<T> current = first;

            while (current.next != null) {
                prev = current;
                current = current.next;
            }

            prev.next = null;
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
        return new LinkedListIterator();
    }

    private static class Node<E> {
        private final E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            final T value = current.value;
            current = current.next;

            return value;
        }
    }
}
