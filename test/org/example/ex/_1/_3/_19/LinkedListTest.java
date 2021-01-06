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

    @Test
    public void findTest1() {
        final LinkedList<Integer> integers = new LinkedList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertTrue(integers.find(2));
        assertFalse(integers.find(4));
    }

    @Test
    public void findTest2() {
        final LinkedList<Integer> integers = new LinkedList<>();

        assertFalse(integers.find(2));
        assertFalse(integers.find(4));
    }

    @Test
    public void removeAfterTest1() {
        final LinkedList<Integer> integers = new LinkedList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertEquals(3, integers.size());
        assertEquals(2, integers.removeAfter(1));
        assertEquals(2, integers.size());
    }

    @Test
    public void removeAfterTest2() {
        final LinkedList<Integer> integers = new LinkedList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);

        assertNull(integers.removeAfter(3));
        assertEquals(3, integers.size());

        assertNull(integers.removeAfter(4));
        assertEquals(3, integers.size());

        assertNull(integers.removeAfter(null));
        assertEquals(3, integers.size());
    }

    @Test
    public void insertAfterTest() {
        final LinkedList<Integer> integers = new LinkedList<>();

        integers.add(1);

        assertTrue(integers.insertAfter(1, 2));
        assertEquals(2, integers.size());

        assertTrue(integers.insertAfter(2, 3));
        assertEquals(3, integers.size());

        assertTrue(integers.insertAfter(1, 4));
        assertEquals(4, integers.size());

        assertFalse(integers.insertAfter(5, 6));
        assertEquals(4, integers.size());

        assertEquals(3, integers.removeLast());
        assertEquals(2, integers.removeLast());
        assertEquals(4, integers.removeLast());
        assertEquals(1, integers.removeLast());
    }
}