package org.example.ex._1._3._33;

public interface IDeque<T> {
    void pushLeft(T value);

    void pushRight(T value);

    T popLeft();

    T popRight();

    int size();

    boolean isEmpty();
}
