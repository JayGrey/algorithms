package org.example.ex._1._4._22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSearchTest {

    @Test
    void find() {
        assertEquals(0, FibonacciSearch.find(new int[]{1, 2, 3}, 1));
        assertEquals(1, FibonacciSearch.find(new int[]{1, 2, 3}, 2));
        assertEquals(2, FibonacciSearch.find(new int[]{1, 2, 3}, 3));
        assertEquals(-1, FibonacciSearch.find(new int[]{1, 2, 3}, 4));
        assertEquals(-1, FibonacciSearch.find(new int[]{1, 2, 3}, 0));
    }
}