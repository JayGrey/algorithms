package org.example.ex._1._3._7;

import org.example.ex._1._3._19.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private transient int N;
    private transient int version;

    public Stack() {
    }

    public Stack(Stack<Item> stack) {
        final Stack<Item> temp = new Stack<>();
        for (Item item : stack) {
            temp.push(item);
        }

        while (!temp.isEmpty()) {
            push(temp.pop());
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        first = new Node<>(item, first);
        N++;
        version++;
    }

    public Item pop() {
        final Item value = first.value;
        first = first.next;
        N--;
        version++;

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

    private class StackIterator implements Iterator<Item> {
        private final int currentVersion = version;
        private Node<Item> currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            if (currentVersion != version) {
                throw new ConcurrentModificationException();
            }
            final Item value = currentNode.value;
            currentNode = currentNode.next;

            return value;
        }
    }
}
