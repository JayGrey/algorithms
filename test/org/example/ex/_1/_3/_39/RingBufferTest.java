package org.example.ex._1._3._39;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingBufferTest {

    @Test
    public void enqueueTest1() {
        final RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
        ringBuffer.enqueue(1);
        ringBuffer.enqueue(2);
        ringBuffer.enqueue(3);

        assertEquals(3, ringBuffer.size());
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        assertEquals(1, ringBuffer.dequeue());
        assertEquals(2, ringBuffer.dequeue());

        assertEquals(1, ringBuffer.size());
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(4);
        ringBuffer.enqueue(5);
        ringBuffer.enqueue(6);

        assertEquals(3, ringBuffer.dequeue());
        assertEquals(4, ringBuffer.dequeue());
        assertFalse(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

        ringBuffer.enqueue(7);
        ringBuffer.enqueue(8);
        ringBuffer.enqueue(9);
        assertEquals(5, ringBuffer.size());
        assertFalse(ringBuffer.isEmpty());
        assertTrue(ringBuffer.isFull());

        assertEquals(5, ringBuffer.dequeue());
        assertEquals(6, ringBuffer.dequeue());
        assertEquals(7, ringBuffer.dequeue());
        assertEquals(8, ringBuffer.dequeue());
        assertEquals(9, ringBuffer.dequeue());
        assertEquals(0, ringBuffer.size());
        assertTrue(ringBuffer.isEmpty());
        assertFalse(ringBuffer.isFull());

    }

    @Test
    public void enqueueTest2() {
        final RingBuffer<Integer> ringBuffer = new RingBuffer<>(0);
        assertEquals(0, ringBuffer.size());
        assertTrue(ringBuffer.isFull());
        assertFalse(ringBuffer.isEmpty());

        assertFalse(ringBuffer.enqueue(1));
        assertNull(ringBuffer.dequeue());

    }

    @Test
    public void enqueueTest3() {
        final RingBuffer<Integer> ringBuffer = new RingBuffer<>(3);

        for (int i = 0; i < 4; i++) {
            ringBuffer.enqueue(i);
        }

        assertEquals(3, ringBuffer.size());
        assertTrue(ringBuffer.isFull());
        assertEquals(0, ringBuffer.dequeue());
        assertEquals(1, ringBuffer.dequeue());
        assertEquals(2, ringBuffer.dequeue());
    }
}