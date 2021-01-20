package org.example.ex._1._3._9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    public void enqueueDequeueTest() {
        final Queue<Integer> integers = new Queue<>();

        integers.enqueue(1);
        integers.enqueue(2);
        integers.enqueue(3);

        assertEquals(1, integers.dequeue());
        assertEquals(2, integers.dequeue());
        assertEquals(3, integers.dequeue());
        assertNull(integers.dequeue());
    }

    @Test
    public void isEmptyTest() {
        final Queue<Integer> integers = new Queue<>();
        assertTrue(integers.isEmpty());

        integers.enqueue(1);
        assertFalse(integers.isEmpty());

        integers.dequeue();
        assertTrue(integers.isEmpty());
    }

    @Test
    public void sizeTest() {
        final Queue<Integer> integers = new Queue<>();
        assertEquals(0, integers.size());

        integers.enqueue(1);
        integers.enqueue(2);
        assertEquals(2, integers.size());

        integers.dequeue();
        assertEquals(1, integers.size());

        integers.dequeue();
        assertEquals(0, integers.size());

        integers.dequeue();
        assertEquals(0, integers.size());
    }

    @Test
    public void clearTest() {
        final Queue<Integer> integers = new Queue<>();
        assertTrue(integers.isEmpty());

        integers.enqueue(1);
        assertFalse(integers.isEmpty());

        integers.clear();
        assertTrue(integers.isEmpty());
    }

    @Test
    public void iteratorTest() {
        final Queue<Integer> integers = new Queue<>();

        for (int i = 0; i < 10; i++) {
            integers.enqueue(i);
        }
        assertEquals(10, integers.size());

        int expected = 0;
        for (Integer integer : integers) {
            assertEquals(expected++, integer);
        }

        assertEquals(10, integers.size());
    }

    @Test
    public void copyConstructorTest() {
        final Queue<Integer> integers1 = new Queue<>();

        for (int i = 0; i < 10; i++) {
            integers1.enqueue(i);
        }

        final Queue<Integer> integers2 = new Queue<>(integers1);

        assertEquals(10, integers1.size());
        assertEquals(10, integers2.size());

        integers1.dequeue();
        integers1.dequeue();

        assertEquals(8, integers1.size());
        assertEquals(10, integers2.size());

        assertEquals(2, integers1.dequeue());
        assertEquals(0, integers2.dequeue());

        assertEquals(7, integers1.size());
        assertEquals(9, integers2.size());

    }
}