package org.example.ex._1._3._29;

import org.example.ex._1._3._14.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListQueueTest {

    @Test
    void enqueue() {
        final Queue<Integer> queue = new CircularLinkedListQueue<>();

        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size());

    }

    @Test
    void dequeue() {
        final Queue<Integer> queue = new CircularLinkedListQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    void isEmpty() {
        final Queue<Integer> queue = new CircularLinkedListQueue<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void size() {
        final Queue<Integer> queue = new CircularLinkedListQueue<>();

        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());

        queue.dequeue();
        assertEquals(0, queue.size());

    }
}