package org.example.ex._1._3._38;

import org.example.ex._1._3._33.ResizingArray;

public class ArrayGeneralizedQueue<Item> implements GeneralizedQueue<Item> {

    private final ResizingArray<Item> array = new ResizingArray<>();

    @Override
    public void insert(Item item) {
        array.addLast(item);
    }

    @Override
    public Item delete(int k) {
        return array.remove(k);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
}
