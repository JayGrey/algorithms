package org.example.ex._1._1._15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void histogram() {
        assertEquals(0, Runner.histogram(null, 0).length);
        assertEquals(0, Runner.histogram(new int[]{}, 0).length);

        assertEquals(0, Runner.histogram(null, -1).length);
        assertEquals(0, Runner.histogram(new int[]{}, -1).length);


        assertEquals(10, Runner.histogram(null, 10).length);
        assertEquals(10, Runner.histogram(new int[]{}, 10).length);

        assertArrayEquals(new int[]{0, 1, 0, 1}, Runner.histogram(new int[]{1, 3, 5}, 4));

        assertArrayEquals(new int[]{1, 1, 1, 1}, Runner.histogram(new int[]{0, 1, 2, 3}, 4));

        assertArrayEquals(new int[]{4, 0, 0, 0}, Runner.histogram(new int[]{0, 0, 0, 0}, 4));

        assertArrayEquals(new int[]{0, 0}, Runner.histogram(new int[]{10}, 2));
    }
}