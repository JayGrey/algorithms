package org.example.ex._1._3._7;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
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

    public Stack<Item> copy() {
        Stack<Item> temp = new Stack<>();

        for (Item item : this) {
            temp.push(item);
        }

        Stack<Item> result = new Stack<>();
        for (Item item : temp) {
            result.push(item);
        }

        return result;
    }

    @Override
    public Iterator<Item> iterator() {

        return new StackIterator();
    }

    private static class Node<E> {
        private final E value;
        private final Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private class StackIterator implements Iterator<Item> {
        private Node<Item> currentNode = first;


        @Override
        public boolean hasNext() {
            return currentNode != null && currentNode.next != null;
        }

        @Override
        public Item next() {
            final Item value = currentNode.value;
            currentNode = currentNode.next;

            return value;
        }
    }
}
