package org.example.ex._1._4._18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {

    @Test
    public void trashData() {
        assertEquals(-1, LocalMinimum.find(null));
        assertEquals(-1, LocalMinimum.find(new int[0]));
        assertEquals(-1, LocalMinimum.find(new int[]{1}));
    }

    @Test
    public void find() {
        assertEquals(1, LocalMinimum.find(new int[]{1, 2, 3}));
        assertEquals(4, LocalMinimum.find(new int[]{5, 4, 3, 2, 6, 8}));
        assertEquals(-1, LocalMinimum.find(new int[]{5, 4, 3, 2, 1, 0}));
    }
}