package org.example.ex._1._4._18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {

    @Test
    public void trashData() {
        assertEquals(-1, LocalMinimum.find(null));
        assertEquals(-1, LocalMinimum.find(new int[0]));
        assertEquals(-1, LocalMinimum.find(new int[]{1}));

        assertEquals(-1, LocalMinimum.findLinear(null));
        assertEquals(-1, LocalMinimum.findLinear(new int[0]));
        assertEquals(-1, LocalMinimum.findLinear(new int[]{1}));
    }

    @Test
    public void find() {
        assertEquals(1, LocalMinimum.find(new int[]{2, 1, 3}));
        assertEquals(4, LocalMinimum.find(new int[]{3, 4, 5, 7, 6, 8}));
        assertEquals(-1, LocalMinimum.find(new int[]{5, 4, 3, 2, 1, 0}));
        assertEquals(8, LocalMinimum.find(new int[]{-8, -7, -6, -5, -4, -3, -2, 8, 0, 9}));

        assertEquals(1, LocalMinimum.findLinear(new int[]{2, 1, 3}));
        assertEquals(4, LocalMinimum.findLinear(new int[]{3, 4, 5, 7, 6, 8}));
        assertEquals(-1, LocalMinimum.findLinear(new int[]{5, 4, 3, 2, 1, 0}));
    }
}