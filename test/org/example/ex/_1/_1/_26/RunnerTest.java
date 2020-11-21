package org.example.ex._1._1._26;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void sort1Test() {
        final int[] array = {2, 1, 3, 4};

        Runner.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4}, array);
    }

    @Test
    void sort2Test() {
        final int[] array = {4, 3, 2, 1};

        Runner.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4}, array);
    }

    @Test
    void sort3Test() {
        final int[] array = {1, 2, 3, 4};

        Runner.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4}, array);
    }

    @Test
    void sort4Test() {
        final int[] array = {};

        Runner.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void sort5Test() {
        final int[] array = {1};

        Runner.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    void sort6Test() {

        try {
            Runner.sort(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("argument is null", e.getMessage());
        }

    }
}