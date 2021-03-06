package org.example.ex._1._3._19;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private int N;

    /**
     * adds element to the end of the list
     */
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

    /**
     * removes last element in the list
     *
     * @return removed element or <b>null</b> if list is empty
     */
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
     * removes all elements whose value is equal to <b>key</b>
     */
    public void removeAll(T key) {
        Node<T> prev = null;
        Node<T> current = first;

        while (current != null) {

            if (Objects.equals(current.value, key)) {
                if (prev == null) {
                    first = current = current.next;
                } else {
                    prev.next = current = current.next;
                }

                N--;
                continue;
            }

            prev = current;
            current = current.next;
        }
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
     * removes first element whose index is <b>k</b>
     */
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

    /**
     * returns max value in the list according to <b>comparator</b>
     */
    public T max(Comparator<T> comparator) {
        if (N == 0 || comparator == null) {
            return null;
        } else if (N == 1) {
            return first.value;
        } else {
            T result = first.value;
            Node<T> current = first.next;
            while (current != null) {

                if (comparator.compare(current.value, result) > 0) {
                    result = current.value;
                }

                current = current.next;
            }

            return result;
        }
    }

    /**
     * recursively searches and returns max value in the list according to <b>comparator</b>
     */
    public T maxR(Comparator<T> comparator) {
        return (N == 0 || comparator == null) ? null : maxRRunner(first.next, first.value, comparator);
    }

    private T maxRRunner(Node<T> current, T maxElement, Comparator<T> comparator) {
        if (current == null) {
            return maxElement;
        } else {
            return maxRRunner(current.next,
                    comparator.compare(current.value, maxElement) > 0 ? current.value : maxElement, comparator);
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
