package org.example.ex._1._4._31;

import org.example.ex._1._3._33.IDeque;
import org.example.ex._1._3._7.IStack;
import org.example.ex._1._3._7.Stack;

public class DequeueWithThreeStacks<T> implements IDeque<T> {
    private final IStack<T> leftStack = new Stack<>();
    private final IStack<T> rightStack = new Stack<>();
    private final IStack<T> tempStack = new Stack<>();

    private boolean filledWithLeft;

    @Override
    public void pushLeft(T value) {
        if (!tempStack.isEmpty() && filledWithLeft) {
            move(tempStack, leftStack);
        }

        leftStack.push(value);
    }

    @Override
    public void pushRight(T value) {
        if (!tempStack.isEmpty() && !filledWithLeft) {
            move(tempStack, rightStack);
        }

        rightStack.push(value);
    }

    @Override
    public T popLeft() {
        if (!leftStack.isEmpty()) {
            return leftStack.pop();
        }

        if (!tempStack.isEmpty() && filledWithLeft) {
            move(tempStack, leftStack);
            return leftStack.pop();
        } else if (!tempStack.isEmpty() && !filledWithLeft) {
            return tempStack.pop();
        }

        if (!rightStack.isEmpty()) {
            move(rightStack, tempStack);
            filledWithLeft = false;
            return tempStack.pop();
        }

        return null;
    }

    @Override
    public T popRight() {
        if (!rightStack.isEmpty()) {
            return rightStack.pop();
        }

        if (!tempStack.isEmpty() && !filledWithLeft) {
            move(tempStack, rightStack);
            return rightStack.pop();
        } else if (!tempStack.isEmpty() && filledWithLeft) {
            return tempStack.pop();
        }

        if (!leftStack.isEmpty()) {
            move(leftStack, tempStack);
            filledWithLeft = true;
            return tempStack.pop();
        }

        return null;
    }

    @Override
    public int size() {
        return leftStack.size() + rightStack.size() + tempStack.size();
    }

    @Override
    public boolean isEmpty() {
        return leftStack.isEmpty() && rightStack.isEmpty() && tempStack.isEmpty();
    }

    private void move(IStack<T> from, IStack<T> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
