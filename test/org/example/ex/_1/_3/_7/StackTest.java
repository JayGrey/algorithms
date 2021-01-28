package org.example.ex._1._3._7;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackTest {

    @Test
    public void isEmptyTest() {
        final Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void sizeTest() {
        final Stack<Integer> stack = new Stack<>();

        assertEquals(0, stack.size());

        stack.push(1);
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void pushAndPopTest() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());

    }

    @Test
    public void peekTest() {
        final Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());

        assertEquals(2, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    public void copyConstructorTest() {
        final Stack<Integer> stack1 = new Stack<>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);

        final Stack<Integer> stack2 = new Stack<>(stack1);

        assertEquals(3, stack1.size());
        assertEquals(3, stack2.size());

        assertEquals(1, stack1.pop());
        assertEquals(2, stack1.size());
        assertEquals(3, stack2.size());

        assertEquals(1, stack2.pop());
        assertEquals(2, stack1.size());
        assertEquals(2, stack2.size());
    }

    @Test
    public void copyTest() {
        final Stack<Integer> stack1 = new Stack<>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);

        final Stack<Integer> stack2 = stack1.copy();

        assertEquals(3, stack1.size());
        assertEquals(3, stack2.size());

        assertEquals(1, stack1.pop());
        assertEquals(2, stack1.size());
        assertEquals(3, stack2.size());

        assertEquals(1, stack2.pop());
        assertEquals(2, stack1.size());
        assertEquals(2, stack2.size());

        stack1.push(1);
        assertEquals(3, stack1.size());
        assertEquals(2, stack2.size());

        stack2.push(1);
        assertEquals(3, stack1.size());
        assertEquals(3, stack2.size());
    }

    @Test
    public void iterator1Test() {
        final Stack<Integer> stack = new Stack<>();

        for (int i = 9; i >= 0; i--) {
            stack.push(i);
        }

        assertEquals(10, stack.size());

        int expected = 0;
        for (Integer integer : stack) {
            assertEquals(expected++, integer);
        }
        assertEquals(10, stack.size());

    }

    @Test
    public void iterator2Test() {
        final Stack<Integer> stack = new Stack<>();

        for (int i = 9; i >= 0; i--) {
            stack.push(i);
        }

        final Iterator<Integer> iterator = stack.iterator();

        assertEquals(0, stack.pop());

        assertThrows(ConcurrentModificationException.class, () -> {
            while (iterator.hasNext()) {
                iterator.next();
            }
        });
    }
}