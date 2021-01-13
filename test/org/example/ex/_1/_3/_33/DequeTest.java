package org.example.ex._1._3._33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void pushLeft() {
        final Deque<Integer> deque = new Deque<>();

        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);

        assertEquals(3, deque.size());
    }

    @Test
    void pushRight() {
        final Deque<Integer> deque = new Deque<>();

        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);

        assertEquals(3, deque.size());
    }

    @Test
    void popLeft() {
        final Deque<Integer> deque = new Deque<>();

        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);

        assertEquals(3, deque.size());

        assertEquals(3, deque.popLeft());
        assertEquals(2, deque.popLeft());
        assertEquals(1, deque.popLeft());

        assertEquals(0, deque.size());
    }

    @Test
    void popRight() {
        final Deque<Integer> deque = new Deque<>();

        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushRight(3);

        assertEquals(3, deque.size());

        assertEquals(3, deque.popRight());
        assertEquals(2, deque.popRight());
        assertEquals(1, deque.popRight());

        assertEquals(0, deque.size());
    }
}