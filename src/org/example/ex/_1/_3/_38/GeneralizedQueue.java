package org.example.ex._1._3._38;

public interface GeneralizedQueue<Item> {
    void insert(Item item);

    Item delete(int k);

    boolean isEmpty();
}
