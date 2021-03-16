package org.example.ex._1._4._28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackWithAQueueTest {

    @Test
    void push() {
        final StackWithAQueue<Integer> stack = new StackWithAQueue<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3,stack.pop());
        assertEquals(2, stack.pop());

        stack.push(4);
        assertEquals(4,stack.pop());
        assertEquals(1, stack.pop());

        assertEquals(0, stack.size());
    }


}