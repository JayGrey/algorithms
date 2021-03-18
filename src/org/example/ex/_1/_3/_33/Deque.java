package org.example.ex._1._3._33;

import org.example.ex._1._3._31.DoubleLinkedList;

import java.util.Iterator;

public class Deque<T> implements IDeque<T>, Iterable<T> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();

    @Override
    public void pushLeft(T value) {
        list.insertFirst(value);
    }

    @Override
    public void pushRight(T value) {
        list.insertLast(value);
    }

    @Override
    public T popLeft() {
        return list.removeFirst();
    }

    @Override
    public T popRight() {
        return list.removeLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }
}
