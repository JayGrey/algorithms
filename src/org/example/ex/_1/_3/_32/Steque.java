package org.example.ex._1._3._32;

import org.example.ex._1._3._31.DoubleLinkedList;

import java.util.Iterator;

public class Steque<T> implements Iterable<T>, ISteque<T> {
    private final DoubleLinkedList<T> list = new DoubleLinkedList<>();

    @Override
    public void push(T value) {
        list.insertFirst(value);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public void enqueue(T value) {
        list.insertLast(value);
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
