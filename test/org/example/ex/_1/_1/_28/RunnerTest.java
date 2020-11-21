package org.example.ex._1._1._28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RunnerTest {

    @Test
    public void emptyTest() {

        assertArrayEquals(new int[0], Runner.removeDuplicates(null));
        assertArrayEquals(new int[0], Runner.removeDuplicates(new int[]{}));
        assertArrayEquals(new int[0], Runner.removeDuplicates(new int[0]));
    }

    @Test
    public void test1() {
        assertArrayEquals(new int[]{1, 2, 3}, Runner.removeDuplicates(new int[]{1, 1, 1, 2, 3}));

    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{1, 2, 3}, Runner.removeDuplicates(new int[]{1, 2, 3, 3, 3}));
    }

    @Test
    public void test3() {
        assertArrayEquals(new int[]{1}, Runner.removeDuplicates(new int[]{1, 1, 1, 1}));
    }

    @Test
    public void test4() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, Runner.removeDuplicates(new int[]{1, 2, 2, 3, 4}));
    }

    @Test
    public void test5() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Runner.removeDuplicates(new int[]{1, 1, 2, 3, 3, 3, 4, 5, 5, 5}));
    }

    @Test
    public void test6() {
        assertArrayEquals(new int[]{1}, Runner.removeDuplicates(new int[]{1}));
    }

}