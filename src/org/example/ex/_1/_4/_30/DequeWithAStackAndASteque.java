package org.example.ex._1._4._30;

import org.example.ex._1._3._32.ISteque;
import org.example.ex._1._3._32.Steque;
import org.example.ex._1._3._33.IDeque;
import org.example.ex._1._3._7.IStack;
import org.example.ex._1._3._7.Stack;

public class DequeWithAStackAndASteque<T> implements IDeque<T> {
    private final ISteque<T> steque = new Steque<>();
    private final IStack<T> stack = new Stack<>();

    @Override
    public void pushLeft(T value) {
        move(stack, steque);
        steque.push(value);
    }

    @Override
    public void pushRight(T value) {
        steque.enqueue(value);
    }

    @Override
    public T popLeft() {
        move(stack, steque);
        return steque.pop();
    }

    @Override
    public T popRight() {
        move(steque, stack);
        return stack.pop();
    }

    @Override
    public int size() {
        return steque.size() + stack.size();
    }

    @Override
    public boolean isEmpty() {
        return steque.isEmpty() && stack.isEmpty();
    }

    private void move(IStack<T> from, IStack<T> to) {
        while (!from.isEmpty()) {
            to.push(from.pop());
        }
    }
}
