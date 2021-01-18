package org.example.ex._1._3._37;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JosephusProblemTest {

    @Test
    public void getSolutionTest1() {
        final JosephusProblem josephusProblem = new JosephusProblem();

        final int[] array = josephusProblem.getSolution(7, 2);

        assertEquals(7, array.length);

        assertArrayEquals(new int[]{1, 3, 5, 0, 4, 2, 6}, array);

    }

    @Test
    public void getSolutionTest2() {
        final JosephusProblem josephusProblem = new JosephusProblem();

        final int[] array = josephusProblem.getSolution(1, 2);

        assertEquals(1, array.length);

        assertArrayEquals(new int[]{0}, array);

    }

    @Test
    public void getSolutionTest3() {
        final JosephusProblem josephusProblem = new JosephusProblem();

        final int[] array = josephusProblem.getSolution(0, 2);

        assertEquals(0, array.length);

        assertArrayEquals(new int[]{}, array);

    }
    @Test
    public void getSolutionTest4() {
        final JosephusProblem josephusProblem = new JosephusProblem();

        final int[] array = josephusProblem.getSolution(2, 0);

        assertEquals(0, array.length);

        assertArrayEquals(new int[]{}, array);

    }
}