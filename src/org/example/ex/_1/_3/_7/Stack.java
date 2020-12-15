package org.example.ex._1._3._7;

public class Stack<Item> {
    private Node<Item> first;
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        first = new Node<>(item, first);
        N++;
    }

    public Item pop() {
        final Item value = first.value;
        first = first.next;
        N--;

        return value;
    }

    public Item peek() {
        return first.value;
    }

    private static class Node<E> {
        private final E value;
        private final Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
