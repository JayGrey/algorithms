package org.example.ex._1._4._18;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {

    @Test
    public void trashDataFind() {
        assertEquals(-1, LocalMinimum.find(null));
        assertEquals(-1, LocalMinimum.find(new int[0]));
    }

    @Test
    public void trashDataFindMatrix() {
        assertArrayEquals(new int[0], LocalMinimum.findMatrix(null));
        assertArrayEquals(new int[0], LocalMinimum.findMatrix(new int[0][]));
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

    @Test
    public void findMatrix() {
        assertArrayEquals(new int[]{0, 0}, LocalMinimum.findMatrix(new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}}));
        assertArrayEquals(new int[]{2, 2}, LocalMinimum.findMatrix(new int[][]{{8, 7, 6}, {5, 4, 3}, {2, 1, 0}}));
        assertArrayEquals(new int[]{2, 2}, LocalMinimum.findMatrix(new int[][]{{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 1, 5}, {4, 3, 2, 6}}));
    }

}