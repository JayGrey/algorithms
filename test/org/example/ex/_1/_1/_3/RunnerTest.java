package org.example.ex._1._1._3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    public void exercise113Test() {
        assertFalse(Runner.exercise1_1_3(new int[]{1, 2, 3}));

        assertTrue(Runner.exercise1_1_3(new int[]{1, 1, 1}));

        assertFalse(Runner.exercise1_1_3(new int[]{1, 1, 2}));
        assertFalse(Runner.exercise1_1_3(new int[]{1, 2, 1}));
        assertFalse(Runner.exercise1_1_3(new int[]{2, 1, 1}));

        assertFalse(Runner.exercise1_1_3(new int[]{1, 2, 2}));
        assertFalse(Runner.exercise1_1_3(new int[]{2, 1, 2}));
        assertFalse(Runner.exercise1_1_3(new int[]{2, 2, 1}));

        assertTrue(Runner.exercise1_1_3(new int[]{1}));

        assertFalse(Runner.exercise1_1_3(new int[]{}));

        assertFalse(Runner.exercise1_1_3(null));
    }
}