package org.example.ex._1._3._7;

public interface IStack<Item> {
    void push(Item item);

    Item pop();

    boolean isEmpty();

    int size();
}
