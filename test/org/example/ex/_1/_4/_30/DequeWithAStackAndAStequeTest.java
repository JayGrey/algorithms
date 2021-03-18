package org.example.ex._1._4._30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeWithAStackAndAStequeTest {
    @Test
    public void test() {
        final DequeWithAStackAndASteque<Integer> deque = new DequeWithAStackAndASteque<>();
        assertEquals(0, deque.size());

        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushRight(3);
        deque.pushRight(4);

        assertEquals(2, deque.popLeft());
        assertEquals(4, deque.popRight());
        assertEquals(1, deque.popLeft());
        assertEquals(3, deque.popRight());

        assertEquals(0, deque.size());
    }
}