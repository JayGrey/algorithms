package org.example.ex._1._3._32;

public interface ISteque<T> {
    void push(T value);

    T pop();

    void enqueue(T value);

    int size();

    boolean isEmpty();
}
