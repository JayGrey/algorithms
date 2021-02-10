package org.example.ex._1._4._2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    @Test
    public void countTest() {

        int[] array = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

        assertEquals(0, ThreeSum.count(array));
    }
}