package org.example.ex._1._4._28;

import org.example.ex._1._3._7.IStack;
import org.example.ex._1._3._9.Queue;

public class StackWithAQueue<T> implements IStack<T> {
    private final Queue<T> queue = new Queue<>();

    @Override
    public void push(T t) {
        queue.enqueue(t);
    }

    @Override
    public T pop() {
        final int size = queue.size() - 1;

        for (int i = 0; i < size; i++) {
            queue.enqueue(queue.dequeue());
        }

        return queue.dequeue();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
