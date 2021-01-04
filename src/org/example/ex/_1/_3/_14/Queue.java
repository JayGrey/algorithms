package org.example.ex._1._3._14;

public interface Queue<Item> {
    void enqueue(Item item);

    Item dequeue();

    boolean isEmpty();

    int size();
}
