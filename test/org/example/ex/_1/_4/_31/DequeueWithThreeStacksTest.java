package org.example.ex._1._4._31;

import org.example.ex._1._3._33.IDeque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DequeueWithThreeStacksTest {

    @Test
    public void test() {
        final IDeque<Integer> dequeue = new DequeueWithThreeStacks<>();

        assertEquals(0, dequeue.size());

        dequeue.pushLeft(1);
        dequeue.pushLeft(2);
        dequeue.pushRight(3);
        dequeue.pushRight(4);

        assertEquals(2, dequeue.popLeft());
        assertEquals(4, dequeue.popRight());
        assertEquals(1, dequeue.popLeft());
        assertEquals(3, dequeue.popRight());

        assertEquals(0, dequeue.size());
    }

    @Test
    public void test2() {
        final IDeque<Integer> dequeue = new DequeueWithThreeStacks<>();

        dequeue.pushLeft(1);
        dequeue.pushLeft(2);

        assertEquals(1, dequeue.popRight());
        assertEquals(2, dequeue.popRight());

    }

    @Test
    public void test3() {
        final IDeque<Integer> dequeue = new DequeueWithThreeStacks<>();

        dequeue.pushRight(1);
        dequeue.pushRight(2);

        assertEquals(1, dequeue.popLeft());
        assertEquals(2, dequeue.popLeft());
    }

    @Test
    public void test4() {
        final IDeque<Integer> dequeue = new DequeueWithThreeStacks<>();

        dequeue.pushLeft(1);
        dequeue.pushLeft(2);
        dequeue.pushLeft(3);
        assertEquals(3, dequeue.popLeft());
        assertEquals(1, dequeue.popRight());
        assertEquals(2, dequeue.popLeft());
    }

    @Test
    public void test5() {
        final IDeque<Integer> dequeue = new DequeueWithThreeStacks<>();

        dequeue.pushRight(1);
        dequeue.pushRight(2);
        dequeue.pushRight(3);

        assertEquals(3, dequeue.popRight());
        assertEquals(1, dequeue.popLeft());
        assertEquals(2, dequeue.popRight());
    }
}