package org.example.ex._1._3._31;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    void insertFirst() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);

        assertEquals(3, list.size());

        final Iterator<Integer> iterator = list.iterator();
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(1, iterator.next());
    }

    @Test
    void insertLast() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);

        assertEquals(3, list.size());

        final Iterator<Integer> iterator = list.iterator();
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());

    }

    @Test
    void insertBefore() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertLast(1);
        list.insertBefore(0, 2);
        list.insertBefore(1, 3);

        assertEquals(3, list.size());


        final Iterator<Integer> iterator = list.iterator();
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(1, iterator.next());
    }

    @Test
    void insertAfter() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertLast(1);
        list.insertAfter(0, 2);
        list.insertAfter(0, 3);

        final Iterator<Integer> iterator = list.iterator();
        assertEquals(1, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(2, iterator.next());

    }

    @Test
    void removeFirst() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);

        assertEquals(1, list.removeFirst());
        assertEquals(2, list.removeFirst());
        assertEquals(3, list.removeFirst());

        assertEquals(0, list.size());
    }

    @Test
    void removeLast() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);

        assertEquals(3, list.removeLast());
        assertEquals(2, list.removeLast());
        assertEquals(1, list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    void remove() {
        final DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);

        assertEquals(2, list.remove(1));
        assertEquals(3, list.remove(1));
        assertEquals(4, list.remove(1));
        assertEquals(1, list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }
}