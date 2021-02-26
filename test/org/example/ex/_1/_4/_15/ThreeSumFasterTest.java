package org.example.ex._1._4._15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumFasterTest {

    @Test
    void count() {
        assertEquals(1, ThreeSumFaster.count(new int[]{1, 2, -3}));
        assertEquals(1, ThreeSumFaster.count(new int[]{1, 2, -3, 0}));
        assertEquals(0, ThreeSumFaster.count(new int[]{11, 2}));
    }
}