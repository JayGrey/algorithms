package org.example.ex._1._3._19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        final LinkedList<Integer> integers = new LinkedList<>();

        assertEquals(0, integers.size());
        assertTrue(integers.isEmpty());

        integers.add(1);
        assertEquals(1, integers.size());
        assertFalse(integers.isEmpty());

        integers.add(2);
        assertEquals(2, integers.size());

        integers.add(3);
        assertEquals(3, integers.size());

        assertEquals(3, integers.removeLast());
        assertEquals(2, integers.size());

        assertEquals(2, integers.removeLast());
        assertEquals(1, integers.size());

        assertEquals(1, integers.removeLast());
        assertEquals(0, integers.size());
        assertTrue(integers.isEmpty());

        assertNull(integers.removeLast());
        assertEquals(0, integers.size());
        assertTrue(integers.isEmpty());
    }

    @Test
    public void deleteTest() {
        final LinkedList<Integer> integers = new LinkedList<>();

        assertNull(integers.delete(0));

        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertNull(integers.delete(-1));
        assertNull(integers.delete(3));
        assertEquals(3, integers.size());

        assertEquals(2, integers.delete(1));
        assertEquals(2, integers.size());

        assertEquals(1, integers.delete(0));
        assertEquals(1, integers.size());

        assertEquals(3, integers.delete(0));
        assertEquals(0, integers.size());
    }
}