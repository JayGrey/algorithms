package org.example.ex._1._4._12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintSameNumbersTest {

    @Test
    void search1() {
        int[] arrayA = new int[]{1, 2, 3, 4, 5};
        int[] arrayB = new int[]{0, 3, 5, 7};

        assertEquals(2, PrintSameNumbers.search(arrayA, arrayB));
    }

    @Test
    void search2() {
        int[] arrayA = new int[]{1, 1, 1};
        int[] arrayB = new int[]{1, 1, 1};

        assertEquals(1, PrintSameNumbers.search(arrayA, arrayB));
    }

    @Test
    void search3() {
        int[] arrayA = new int[]{1, 2, 3};
        int[] arrayB = new int[]{4, 5, 6};

        assertEquals(0, PrintSameNumbers.search(arrayA, arrayB));
    }

    @Test
    void search4() {
        int[] arrayA = new int[]{1, 2, 3};
        int[] arrayB = new int[]{};

        assertEquals(0, PrintSameNumbers.search(arrayA, arrayB));
    }

    @Test
    void search5() {
        int[] arrayA = new int[]{};
        int[] arrayB = new int[]{1, 2, 3};

        assertEquals(0, PrintSameNumbers.search(arrayA, arrayB));
    }

    @Test
    void search6() {
        int[] arrayA = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] arrayB = new int[]{2};

        assertEquals(1, PrintSameNumbers.search(arrayA, arrayB));
    }
}