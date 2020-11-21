package org.example.ex._1._1._14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
    @Test
    public void lgTest() {
        assertEquals(1, Runner.lg(0));
        assertEquals(3, Runner.lg(8));
        assertEquals(3, Runner.lg(9));
        assertEquals(10, Runner.lg(1024));
        assertEquals(20, Runner.lg(1048580));
    }

    @Test
    public void lg2Test() {
        assertEquals(1, Runner.lg_2(0));
        assertEquals(3, Runner.lg_2(8));
        assertEquals(3, Runner.lg_2(9));
        assertEquals(10, Runner.lg_2(1024));
        assertEquals(20, Runner.lg_2(1048580));
    }
}