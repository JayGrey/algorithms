package org.example.ex._1._3._32;

import org.example.ex._1._3._31.DoubleLinkedList;

import java.util.Iterator;

public class Steque<T> implements Iterable<T> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();

    public void push(T value) {
        list.insertFirst(value);
    }

    public T pop() {
        return list.removeFirst();
    }

    public void enqueue(T value) {
        list.insertLast(value);
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
