package org.example.ex._1._3._35;

import org.example.ex._1._3._14.Queue;
import org.example.ex._1._3._33.ResizingArray;

public class ResizingArrayQueue<T> implements Queue<T> {
    private final ResizingArray<T> array = new ResizingArray<>();

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T dequeue() {
        return array.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int size() {
        return array.size();
    }
}
