package org.example.ex._1._4._11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticSETofIntsTest {

    @Test
    void contains1() {
        final StaticSETofInts set = new StaticSETofInts(new int[]{1, 1, 1, 1});
        assertTrue(set.contains(1));
        assertFalse(set.contains(2));
    }

    @Test
    void contains2() {
        final StaticSETofInts set = new StaticSETofInts(new int[]{});
        assertFalse(set.contains(1));
        assertFalse(set.contains(2));
    }

    @Test
    void howMany() {
        final StaticSETofInts set = new StaticSETofInts(new int[]{1, 1, 1, 1});

        assertEquals(4, set.howMany(1));
        assertEquals(0, set.howMany(2));
    }
}