package org.example.ex._1._4._27;

import org.example.ex._1._3._14.Queue;
import org.example.ex._1._3._7.Stack;

public class QueueWithTwoStacks<T> implements Queue<T> {
    private final Stack<T> leftStack = new Stack<>();
    private final Stack<T> rightStack = new Stack<>();

    @Override
    public void enqueue(T t) {
        if (!rightStack.isEmpty()) {
            move(rightStack, leftStack);
        }

        leftStack.push(t);
    }

    @Override
    public T dequeue() {
        if (!leftStack.isEmpty()) {
            move(leftStack, rightStack);
        }

        return rightStack.pop();
    }

    @Override
    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty();
    }

    @Override
    public int size() {
        return leftStack.size() + rightStack.size();
    }

    private void move(Stack<T> s1, Stack<T> s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
