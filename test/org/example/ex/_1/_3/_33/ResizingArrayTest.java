package org.example.ex._1._3._33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayTest {

    @Test
    public void addFirstTest() {
        final ResizingArray<Integer> integers = new ResizingArray<>();

        for (int i = 0; i < 10; i++) {
            integers.addFirst(i);
        }
        assertEquals(10, integers.size());

        for (int i = 0; i < integers.size(); i++) {
            assertEquals(i, integers.get(integers.size() - i - 1));

        }
    }

    @Test
    public void addLastTest() {
        final ResizingArray<Integer> integers = new ResizingArray<>();

        for (int i = 0; i < 10; i++) {
            integers.addLast(i);
        }
        assertEquals(10, integers.size());

        for (int i = 0; i < integers.size(); i++) {
            assertEquals(i, integers.get(i));

        }
    }

    @Test
    public void removeTest() {
        final ResizingArray<Integer> integers = new ResizingArray<>();

        integers.addLast(1);
        integers.addLast(2);
        integers.addLast(3);
        integers.addLast(4);

        assertEquals(2, integers.remove(1));
        assertEquals(3, integers.size());
        assertEquals(1, integers.get(0));
        assertEquals(3, integers.get(1));
        assertEquals(4, integers.get(2));

        assertEquals(3, integers.remove(1));
        assertEquals(2, integers.size());
        assertEquals(1, integers.get(0));
        assertEquals(4, integers.get(1));

        assertEquals(4, integers.remove(1));
        assertEquals(1, integers.size());
        assertEquals(1, integers.get(0));

        assertEquals(1, integers.remove(0));
        assertEquals(0, integers.size());

    }

    @Test
    public void setAndGetTest() {
        final ResizingArray<Integer> integers = new ResizingArray<>();

        integers.addLast(1);
        integers.addLast(2);
        integers.addLast(3);

        assertEquals(1, integers.set(0, 3));
        assertEquals(2, integers.set(1, 2));
        assertEquals(3, integers.set(2, 1));
        assertEquals(3, integers.size());

        assertEquals(3, integers.get(0));
        assertEquals(2, integers.get(1));
        assertEquals(1, integers.get(2));
        assertEquals(3, integers.size());

    }
}