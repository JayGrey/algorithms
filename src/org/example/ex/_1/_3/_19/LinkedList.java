package org.example.ex._1._3._19;

import java.util.Iterator;
import java.util.Objects;

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

    /**
     * removes element after element with value <b>key</b>
     */
    public T removeAfter(T key) {
        Node<T> current = first;

        while (current != null) {

            if (Objects.equals(current.value, key)) {
                Node<T> next = current.next;
                if (next == null) {
                    return null;
                } else {
                    current.next = next.next;
                    N--;
                    return next.value;
                }
            }

            current = current.next;
        }

        return null;
    }

    /**
     * inserts element with value <b>inserted</b> after element with value <b>element</b>
     *
     * @param element  node after which inserts
     * @param inserted element which should be inserted after
     * @return <b>true</b> if insertion is successful <b>false</b> otherwise
     */
    public boolean insertAfter(T element, T inserted) {

        Node<T> current = first;

        while (current != null) {
            if (Objects.equals(current.value, element)) {
                Node<T> next = current.next;
                current.next = new Node<>(inserted, next);
                N++;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    /**
     * removes first element whose value is <b>k</b>
     * */
    public T delete(int k) {
        if (first == null || k < 0 || k >= N) {
            return null;
        }

        if (k == N - 1) {
            return removeLast();
        }

        Node<T> prev = first;
        Node<T> current = first;

        for (int i = 0; i < k; i++) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;
        N--;

        return current.value;
    }

    public boolean find(T key) {
        Node<T> current = first;

        while (current != null) {
            if (Objects.equals(current.value, key)) {
                return true;
            }

            current = current.next;
        }

        return false;
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
