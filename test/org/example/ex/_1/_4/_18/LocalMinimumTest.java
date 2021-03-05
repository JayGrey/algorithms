package org.example.ex._1._4._18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {

    @Test
    public void trashData() {
        assertEquals(-1, LocalMinimum.find(null));
        assertEquals(-1, LocalMinimum.find(new int[0]));

    }

    @Test
    public void find() {
        assertEquals(0, LocalMinimum.find(new int[]{0}));
        assertEquals(1, LocalMinimum.find(new int[]{1, 0}));
        assertEquals(0, LocalMinimum.find(new int[]{0, 1}));

        assertEquals(0, LocalMinimum.find(new int[]{0, 1, 2}));
        assertEquals(1, LocalMinimum.find(new int[]{1, 0, 2}));
        assertEquals(2, LocalMinimum.find(new int[]{1, 2, 0}));

        assertEquals(0, LocalMinimum.find(new int[]{1, 2, 3, 4, 5, 0}));
        assertEquals(4, LocalMinimum.find(new int[]{5, 4, 3, 2, 0, 1}));

    }
}