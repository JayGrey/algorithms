package org.example.ex._1._4._20;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitonicSearchTest {

    @Test
    void trashData() {
        assertEquals(-1, BitonicSearch.find(null, 1));
        assertEquals(-1, BitonicSearch.find(new int[0], 1));
    }

    @Test
    public void find() {
        assertEquals(6, BitonicSearch.find(new int[]{1, 3, 5, 7, 6, 4, 2, 0}, 2));
        assertEquals(1, BitonicSearch.find(new int[]{1, 3, 5, 7, 6, 4, 2, 0}, 3));
    }
}