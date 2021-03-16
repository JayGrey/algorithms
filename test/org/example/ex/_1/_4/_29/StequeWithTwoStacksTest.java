package org.example.ex._1._4._29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StequeWithTwoStacksTest {

    @Test
    void test() {
        final StequeWithTwoStacks<Integer> steque = new StequeWithTwoStacks<>();

        steque.push(1);
        steque.push(2);
        steque.enqueue(3);
        assertEquals(3, steque.size());

        assertEquals(2, steque.pop());
        assertEquals(1, steque.pop());
        assertEquals(3, steque.pop());
        assertEquals(0, steque.size());
    }
}