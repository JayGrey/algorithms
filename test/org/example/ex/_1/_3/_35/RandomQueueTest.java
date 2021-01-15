package org.example.ex._1._3._35;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomQueueTest {

    @Test
    void enqueue() {
        final RandomQueue<Integer> queue = new RandomQueue<>();

        assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }

        assertEquals(10, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void dequeue() {
        final RandomQueue<Integer> queue = new RandomQueue<>();

        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();

        assertEquals(0, queue.size());
    }

    @Test
    void sample() {
        final RandomQueue<Integer> queue = new RandomQueue<>();

        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.print(queue.sample() + " ");
        }
        System.out.println();

        assertEquals(20, queue.size());
    }
}