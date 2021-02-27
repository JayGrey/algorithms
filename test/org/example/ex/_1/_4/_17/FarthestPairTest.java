package org.example.ex._1._4._17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FarthestPairTest {

    @Test
    void trashData() {
        assertArrayEquals(new double[0], FarthestPair.find(null));
        assertArrayEquals(new double[0], FarthestPair.find(new double[0]));
        assertArrayEquals(new double[0], FarthestPair.find(new double[]{1}));
    }

    @Test
    void find() {
        assertArrayEquals(new double[]{0, 0}, FarthestPair.find(new double[]{0, 0, 0}));
        assertArrayEquals(new double[]{-3, 2}, FarthestPair.find(new double[]{2, 0, 1, -3}));
    }
}