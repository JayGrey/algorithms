package org.example.ex._1._3._38;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayGeneralizedQueueTest {

    @Test
    public void insertTest() {
        final GeneralizedQueue<Integer> queue = new ArrayGeneralizedQueue<>();

        assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }

        assertFalse(queue.isEmpty());
    }

    @Test
    public void deleteTest() {

        final GeneralizedQueue<Integer> queue = new ArrayGeneralizedQueue<>();

        assertTrue(queue.isEmpty());

        for (int i = 0; i < 10; i++) {
            queue.insert(i);
        }

        int[] actualArray = new int[10];
        int index = 0;
        for (int i = 0; i < 9; i++) {
            actualArray[index++] = queue.delete(1);
        }
        actualArray[9] = queue.delete(0);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, actualArray);

        assertTrue(queue.isEmpty());
    }
}