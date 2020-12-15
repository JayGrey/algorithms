package org.example.ex._1._3._9;

public class Queue<Item> {

    private Node<Item> first;
    private Node<Item> last;
    private int N;

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
        final Item value = first.value;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        N--;

        return value;
    }

    public void clear() {
        first = last = null;
        N = 0;
    }

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
