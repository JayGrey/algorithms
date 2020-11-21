package org.example.ex._1._1._29;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void rank() {
        assertEquals(0, Runner.rank(0, null));
        assertEquals(0, Runner.rank(0, new int[0]));

        assertEquals(2, Runner.rank(3, new int[]{1, 2, 3, 3, 4, 5}));
        assertEquals(6, Runner.rank(6, new int[]{1, 2, 3, 3, 4, 5}));
        assertEquals(0, Runner.rank(-1, new int[]{1, 2, 3, 3, 4, 5}));
    }

    @Test
    void count() {
        assertEquals(0, Runner.count(0, null));
        assertEquals(0, Runner.count(0, new int[0]));

        assertEquals(2, Runner.count(3, new int[]{1, 2, 3, 3, 4, 5}));

        assertEquals(6, Runner.count(3, new int[]{3, 3, 3, 3, 3, 3}));

        assertEquals(0, Runner.count(3, new int[]{1, 2, 4, 5}));

        assertEquals(0, Runner.count(6, new int[]{1, 2, 4, 5}));

        assertEquals(0, Runner.count(-1, new int[]{1, 2, 4, 5}));

    }
}