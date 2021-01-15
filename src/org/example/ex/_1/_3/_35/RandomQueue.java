package org.example.ex._1._3._35;

import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._3._14.Queue;
import org.example.ex._1._3._33.ResizingArray;

public class RandomQueue<T> implements Queue<T> {

    private final ResizingArray<T> array = new ResizingArray<>();

    public void enqueue(T item) {
        array.addLast(item);
    }

    public T dequeue() {
        final int index = StdRandom.uniform(0, array.size());
        final T temp = array.get(index);
        array.set(index, array.get(array.size() - 1));
        array.set(array.size() - 1, temp);
        array.remove(array.size() - 1);

        return temp;
    }

    public T sample() {
        return array.get(StdRandom.uniform(0, array.size()));
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }
}
