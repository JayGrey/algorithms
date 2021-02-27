package org.example.ex._1._4._16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPairTest {

    @Test
    void trashData() {
        assertArrayEquals(new double[0], ClosestPair.find(null));
        assertArrayEquals(new double[0], ClosestPair.find(new double[0]));
        assertArrayEquals(new double[0], ClosestPair.find(new double[]{1.0}));
    }

    @Test
    void find() {
        final double[] result = ClosestPair.find(new double[]{-1.8, -2, -5, 9.9998, 0, 10, 12});
        assertArrayEquals(new double[]{9.9998, 10.0}, result);
    }
}