package org.example.ex._1._3._1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackOfStringsTest {

    @Test
    public void constructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new FixedCapacityStackOfStrings(-1));
        assertThrows(IllegalArgumentException.class, () -> new FixedCapacityStackOfStrings(0));
    }

    @Test
    public void isEmptyTest() {
        final FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(10);

        assertTrue(stack.isEmpty());

        stack.push("string");
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());

    }

    @Test
    public void isFullTest() {
        final FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);

        assertFalse(stack.isFull());

        stack.push("string");
        stack.push("string");
        assertTrue(stack.isFull());

        stack.pop();
        assertFalse(stack.isFull());
    }

    @Test
    public void sizeTest() {
        final FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);

        assertEquals(0, stack.size());

        stack.push("string");
        assertEquals(1, stack.size());

        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void pushAndPopTest() {
        final FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(2);

        stack.push("abc");
        stack.push("def");

        assertEquals("def", stack.pop());
        assertEquals("abc", stack.pop());
    }
}