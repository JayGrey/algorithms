package org.example.ex._1._3._34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomBagTest {

    @Test
    void add() {
        final RandomBag<Integer> randomBag = new RandomBag<>();
        assertEquals(0, randomBag.size());
        assertTrue(randomBag.isEmpty());

        randomBag.add(1);
        randomBag.add(2);
        randomBag.add(3);

        assertEquals(3, randomBag.size());
        assertFalse(randomBag.isEmpty());


    }

    @Test
    void iterator() {
        final RandomBag<Integer> randomBag = new RandomBag<>();

        for (int i = 0; i < 10; i++) {
            randomBag.add(i);
        }

        assertEquals(10, randomBag.size());

        for (Integer integer : randomBag) {
            System.out.print(integer + " ");
        }

        System.out.println();
    }
}