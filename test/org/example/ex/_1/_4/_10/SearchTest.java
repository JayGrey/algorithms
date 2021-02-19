package org.example.ex._1._4._10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void smallestRank1() {
        assertEquals(-1, Search.smallestRank(new int[0], 0, 100, 0));
        assertEquals(-1, Search.smallestRank(new int[0], -1, 100, 0));
        assertEquals(-1, Search.smallestRank(new int[0], 20, 10, 0));
        assertEquals(-1, Search.smallestRank(new int[]{1, 2, 3, 4}, 0, 100, 0));
        assertEquals(-1, Search.smallestRank(new int[]{1, 2, 3, 4}, 2, 100, 0));
    }

    @Test
    void smallestRank2() {
        assertEquals(2, Search.smallestRank(new int[]{0, 1, 2, 3, 4}, 2));
        assertEquals(0, Search.smallestRank(new int[]{0, 1, 2, 3, 4}, 0));
        assertEquals(4, Search.smallestRank(new int[]{0, 1, 2, 3, 4}, 4));
    }

    @Test
    void smallestRank3() {
        assertEquals(0, Search.smallestRank(new int[]{0}, 0));
        assertEquals(-1, Search.smallestRank(new int[]{1}, 0));
        assertEquals(-1, Search.smallestRank(new int[]{0}, 1));
    }

    @Test
    void smallestRank4() {
        assertEquals(0, Search.smallestRank(new int[]{1, 1, 1, 2, 2, 3}, 1));
        assertEquals(1, Search.smallestRank(new int[]{0, 1, 1, 1, 1, 1}, 1));
    }
}