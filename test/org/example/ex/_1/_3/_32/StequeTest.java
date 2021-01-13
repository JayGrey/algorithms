package org.example.ex._1._3._32;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StequeTest {

    @Test
    void push() {
        final Steque<Integer> steque = new Steque<>();

        steque.push(1);
        steque.push(2);
        steque.push(3);

        assertEquals(3, steque.size());
    }

    @Test
    void pop() {
        final Steque<Integer> steque = new Steque<>();

        steque.push(1);
        steque.push(2);
        steque.push(3);

        assertEquals(3, steque.pop());
        assertEquals(2, steque.pop());
        assertEquals(1, steque.pop());

        assertEquals(0, steque.size());
    }

    @Test
    void enqueue() {
        final Steque<Integer> steque = new Steque<>();

        steque.push(1);
        steque.push(2);
        steque.push(3);

        steque.enqueue(4);

        assertEquals(3, steque.pop());
        assertEquals(2, steque.pop());
        assertEquals(1, steque.pop());
        assertEquals(4, steque.pop());

        assertEquals(0, steque.size());

    }
}