package org.example.ex._1._3._3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {

    @Test
    void validate() {
        assertTrue(Runner.validate(4, 3, 2, 1, 0, 9, 8, 7, 6, 5));
        assertFalse(Runner.validate(4, 6, 8, 7, 5, 3, 2, 9, 0, 1));
        assertTrue(Runner.validate(2, 5, 6, 7, 4, 8, 9, 3, 1, 0));
        assertTrue(Runner.validate(4, 3, 2, 1, 0, 5, 6, 7, 8, 9));
        assertTrue(Runner.validate(1, 2, 3, 4, 5, 6, 9, 8, 7, 0));
        assertFalse(Runner.validate(0, 4, 6, 5, 3, 8, 1, 7, 2, 9));
        assertFalse(Runner.validate(1, 4, 7, 9, 8, 6, 5, 3, 0, 2));
        assertFalse(Runner.validate(1, 4, 7, 9, 8, 6, 5, 3, 0, 2));
        assertTrue(Runner.validate(2, 1, 4, 3, 6, 5, 8, 7, 9, 0));
    }
}