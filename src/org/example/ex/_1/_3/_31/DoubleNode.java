package org.example.ex._1._3._31;

public class DoubleNode<T> {
    final T value;
    DoubleNode<T> prev;
    DoubleNode<T> next;

    public DoubleNode(T value, DoubleNode<T> prev, DoubleNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}
