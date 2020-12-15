package org.example.ex._1._3._7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackTest {

    @Test
    void isEmpty() {
        final Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void size() {
        final Stack<Integer> stack = new Stack<>();

        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());;

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void pushAndPop() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

    }

    @Test
    void peek() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
    }
}