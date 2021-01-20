package org.example.ex._1._3._9;

import org.example.ex._1._3._19.Node;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private transient int N;

    public Queue() {
    }

    public Queue(Queue<Item> other) {
        for (Item item : other) {
            enqueue(item);
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        final Node<Item> oldLast = last;
        last = new Node<>(item, null);

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }

        N++;
    }

    public Item dequeue() {
        if (N == 0) {
            return null;
        }

        final Item value = first.value;

        if (N == 1) {
            first = last = null;
        } else {
            first = first.next;
        }

        N--;

        return value;
    }

    public void clear() {
        first = last = null;
        N = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
        private Node<Item> current = first;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            final Item value = current.value;
            current = current.next;
            return value;
        }
    }
}
