package org.example.ex._1._4._18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {

    @Test
    public void trashData() {
        assertEquals(-1, LocalMinimum.find(null));
        assertEquals(-1, LocalMinimum.find(new int[0]));
        assertEquals(-1, LocalMinimum.find(new int[]{1}));

        assertEquals(-1, LocalMinimum.findFirst(null, 1, 2));
        assertEquals(-1, LocalMinimum.findFirst(new int[0], 1, 2));
        assertEquals(-1, LocalMinimum.findFirst(new int[]{1}, 1, 2));
        assertEquals(-1, LocalMinimum.findFirst(new int[]{1, 2, 3}, 2, 1));
        assertEquals(-1, LocalMinimum.findFirst(new int[]{1, 2, 3}, 2, 0));

        // matrix
        assertArrayEquals(new int[0], LocalMinimum.findMatrix(null));
        assertArrayEquals(new int[0], LocalMinimum.findMatrix(new int[0][0]));
        assertArrayEquals(new int[0], LocalMinimum.findMatrix(new int[][]{{1}}));
    }

    @Test
    public void find() {
        assertEquals(1, LocalMinimum.find(new int[]{2, 1, 3}));
        assertEquals(4, LocalMinimum.find(new int[]{7, 6, 5, 4, 2, 8}));
        assertEquals(-1, LocalMinimum.find(new int[]{5, 4, 3, 2, 1, 0}));
    }

    @Test
    public void findFirstLocalMinimumTest() {
        assertEquals(1, LocalMinimum.findFirst(new int[]{2, 1, 3}, 0, 2));
        assertEquals(1, LocalMinimum.findFirst(new int[]{2, 1, 3, 4, 6}, 0, 4));
        assertEquals(3, LocalMinimum.findFirst(new int[]{7, 6, 4, 3, 5}, 2, 4));
    }

    @Test
    public void findLocalMinimumMatrixTest() {
        assertArrayEquals(new int[]{1, 1}, LocalMinimum.findMatrix(new int[][]{{3, 2, 9}, {4, 1, 8}, {5, 6, 7}}));
        assertArrayEquals(new int[]{2, 2}, LocalMinimum.findMatrix(
                new int[][]{{11, -1, -3, 10}, {9, 2, 1, 8}, {-2, 3, 0, 7}, {12, 4, 5, 6}}));
    }
}