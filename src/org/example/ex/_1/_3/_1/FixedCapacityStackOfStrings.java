package org.example.ex._1._3._1;

public class FixedCapacityStackOfStrings {

    private final FixedCapacityStack<String> stack;

    public FixedCapacityStackOfStrings(int n) {
        stack = new FixedCapacityStack<>(n);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.isFull();
    }

    public int size() {
        return stack.size();
    }

    public void push(String s) {
        stack.push(s);
    }

    public String pop() {
        return stack.pop();
    }
}
