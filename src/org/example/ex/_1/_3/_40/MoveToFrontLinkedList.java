package org.example.ex._1._3._40;

import org.example.ex._1._3._19.Node;

import java.util.Iterator;
import java.util.Objects;

public final class MoveToFrontLinkedList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;

    /**
     * Move element to the beginning of list, if element already in list, remove it and move to front
     */
    public void add(Item item) {
        removeElement(item);
        first = new Node<>(item, first);
        N++;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void removeElement(Item item) {
        if (N == 0) {
            return;
        }

        Node<Item> currentNode = first;
        Node<Item> previousNode = null;

        while (currentNode != null) {

            if (Objects.equals(currentNode.value, item)) {
                if (previousNode == null) {
                    first = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                N--;
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new MoveToFrontLinkedListIterator();
    }

    private class MoveToFrontLinkedListIterator implements Iterator<Item> {
        private Node<Item> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            final Item value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }
}
