package org.example.ex._1._3._40;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MoveToFrontLinkedListTest {

    @Test
    public void addTest1() {
        final MoveToFrontLinkedList<Integer> list = new MoveToFrontLinkedList<>();
        list.add(1);
        list.add(2);

        assertEquals(2, list.size());

        final Iterator<Integer> iterator = list.iterator();
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
    }

 @Test
    public void addTest2() {
        final MoveToFrontLinkedList<Integer> list = new MoveToFrontLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);

        assertEquals(2, list.size());

        final Iterator<Integer> iterator = list.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
    }

    @Test
    public void addTest3() {
        final MoveToFrontLinkedList<Integer> list = new MoveToFrontLinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);

        assertEquals(1, list.size());

        final Iterator<Integer> iterator = list.iterator();
        assertEquals(1, iterator.next());
        assertFalse(list.isEmpty());
    }
}