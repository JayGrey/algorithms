package org.example.ex._1._3._38;

import org.example.ex._1._3._19.LinkedList;

public class LinkedListGeneralizedQueue<Item> implements GeneralizedQueue<Item> {

    private final LinkedList<Item> list = new LinkedList<>();

    @Override
    public void insert(Item item) {
        list.add(item);
    }

    @Override
    public Item delete(int k) {
        return list.delete(k);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
