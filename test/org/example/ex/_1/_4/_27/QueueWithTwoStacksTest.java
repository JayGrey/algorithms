package org.example.ex._1._4._27;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueWithTwoStacksTest {

    @Test
    void enqueue() {
        final QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
    }

    @Test
    void dequeue() {
        final QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    void isEmpty() {
        final QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        final QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        assertEquals(0, queue.size());

        queue.enqueue(1);
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueDequeueTest() {
        final QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();

        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(6);

        assertEquals(3, queue.size());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}