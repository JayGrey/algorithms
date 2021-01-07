package org.example.ex._1._3._19;

public class Node<E> {
    public final E value;
    public Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}
