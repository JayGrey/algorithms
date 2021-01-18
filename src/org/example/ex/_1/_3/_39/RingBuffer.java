package org.example.ex._1._3._39;

public class RingBuffer<Item> {
    private final int capacity;

    private final Item[] array;
    private int currentIndex;
    private int N;

    public RingBuffer(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        array = createArray(capacity);
        currentIndex = N = 0;
    }

    public boolean enqueue(Item item) {
        if (isFull()) {
            return false;
        }
        if (currentIndex == array.length) {
            currentIndex = 0;
        }

        array[currentIndex++] = item;
        N++;

        return true;
    }

    public Item dequeue() {
        if (isEmpty() || capacity == 0) {
            return null;
        }

        final int a = currentIndex - N;
        final int itemIndex = a < 0 ? capacity - Math.abs(a) : a;
        final Item item = array[itemIndex];
        array[itemIndex] = null;

        N--;

        return item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0 && capacity > 0;
    }

    public boolean isFull() {
        return N >= capacity;
    }

    @SuppressWarnings("unchecked")
    private Item[] createArray(int N) {
        return (Item[]) new Object[N];
    }
}
