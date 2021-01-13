package org.example.ex._1._3._33;

import org.example.ex._1._3._31.DoubleLinkedList;

import java.util.Iterator;

public class Deque<T> implements Iterable<T> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();

    public void pushLeft(T value) {
        list.insertFirst(value);
    }

    public void pushRight(T value) {
        list.insertLast(value);
    }

    public T popLeft() {
        return list.removeFirst();
    }

    public T popRight() {
        return list.removeLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }
}
