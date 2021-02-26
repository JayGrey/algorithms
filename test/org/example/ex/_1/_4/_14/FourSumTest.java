package org.example.ex._1._4._14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourSumTest {

    @Test
    void countQuadNumber() {
        assertEquals(2, FourSum.countQuadNumber(new int[]{1, 2, 3, 0, 0, -6, 2}));
    }
}