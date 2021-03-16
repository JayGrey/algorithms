package org.example.ex._1._4._29;

import org.example.ex._1._3._32.ISteque;
import org.example.ex._1._3._7.Stack;

public class StequeWithTwoStacks<T> implements ISteque<T> {
    private final Stack<T> mainStack = new Stack<>();
    private final Stack<T> additionalStack = new Stack<>();

    @Override
    public void push(T value) {
        mainStack.push(value);
    }

    @Override
    public T pop() {
        return mainStack.pop();
    }

    @Override
    public void enqueue(T value) {
        while (!mainStack.isEmpty()) {
            additionalStack.push(mainStack.pop());
        }

        mainStack.push(value);

        while (!additionalStack.isEmpty()) {
            mainStack.push(additionalStack.pop());
        }
    }

    @Override
    public int size() {
        return mainStack.size();
    }

    @Override
    public boolean isEmpty() {
        return mainStack.isEmpty();
    }
}
