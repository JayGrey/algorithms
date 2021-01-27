package org.example.ex._1._3._48;

import org.example.ex._1._3._33.Deque;

public class TwoStacks<T> {
    private final Deque<T> deque = new Deque<>();
    private int leftSize = 0;
    private int rightSize = 0;

    public void leftStackPush(T value) {
        leftSize++;
        deque.pushLeft(value);
    }

    // left stack
    public T leftStackPop() {
        if (leftSize == 0) {
            return null;
        }

        leftSize--;
        return deque.popLeft();
    }

    public int leftStackSize() {
        return leftSize;
    }

    public boolean isLeftStackEmpty() {
        return leftSize == 0;
    }

    // right stack
    public void rightStackPush(T value) {
        rightSize++;
        deque.pushRight(value);
    }

    public T rightStackPop() {
        if (rightSize == 0) {
            return null;
        }

        rightSize--;
        return deque.popRight();
    }

    public int rightStackSize() {
        return rightSize;
    }

    public boolean isRightStackEmpty() {
        return rightSize == 0;
    }
}
