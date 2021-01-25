package org.example.ex._1._3._44;

import org.example.ex._1._3._7.Stack;

public class Buffer {
    private final Stack<Character> leftPart = new Stack<>();
    private final Stack<Character> rightPart = new Stack<>();

    public void insert(char k) {
        leftPart.push(k);
    }

    public char delete() {
        return rightPart.pop();
    }

    public void left(int k) {
        if (k > leftPart.size()) {
            return;
        }

        for (int i = 0; i < k; i++) {
            rightPart.push(leftPart.pop());
        }

    }

    public void right(int k) {
        if (k > rightPart.size()) {
            return;
        }

        for (int i = 0; i < k; i++) {
            leftPart.push(rightPart.pop());
        }
    }

    public int size() {
        return leftPart.size() + rightPart.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Character ch : rightPart) {
            builder.insert(0, ch);
        }

        for (Character ch : leftPart) {
            builder.insert(0, ch);
        }

        return builder.toString();
    }
}
