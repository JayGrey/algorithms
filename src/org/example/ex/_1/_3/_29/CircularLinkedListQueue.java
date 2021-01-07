package org.example.ex._1._3._29;

import org.example.ex._1._3._14.Queue;
import org.example.ex._1._3._19.Node;

public class CircularLinkedListQueue<T> implements Queue<T> {
    private Node<T> last;
    private int N;

    @Override
    public void enqueue(T value) {
        if (last == null) {
            last = new Node<>(value, null);
            last.next = last;
        } else {
            final Node<T> newLast = new Node<>(value, last.next);
            last.next = newLast;
            last = newLast;
        }

        N++;
    }

    @Override
    public T dequeue() {
        if (N == 0) {
            return null;
        }

        T result;
        if (N == 1) {
            result = last.value;
        } else {
            final Node<T> first = last.next;
            last.next = first.next;
            result = first.value;
        }

        N--;
        return result;
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
