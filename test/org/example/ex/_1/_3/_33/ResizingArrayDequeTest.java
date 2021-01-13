package org.example.ex._1._3._33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayDequeTest {

    @Test
    public void pushLeftTest() {
        final ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.pushLeft(i);
        }

        assertEquals(10, deque.size());
    }

    @Test
    public void pushRightTest() {
        final ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.pushRight(i);
        }

        assertEquals(10, deque.size());
    }

    @Test
    public void popLeftTest() {
        final ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.pushRight(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, deque.popLeft());
        }

        assertEquals(0, deque.size());
    }

    @Test
    public void popRightTest() {
        final ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        assertTrue(deque.isEmpty());

        for (int i = 0; i < 10; i++) {
            deque.pushLeft(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i, deque.popRight());
        }

        assertEquals(0, deque.size());
    }

    @Test
    public void iteratorTest() {
        final ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();

        for (int i = 0; i < 10; i++) {
            deque.pushRight(i);
        }

        int i = 0;
        for (Integer integer : deque) {
            assertEquals(i++, integer);
        }
    }
}