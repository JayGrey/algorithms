package org.example.ex._1._2._9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    public void test() {
        final Counter counter = new Counter("counter");

        assertEquals(0, counter.tally());

        counter.increment();
        assertEquals(1, counter.tally());

        counter.decrement();
        assertEquals(0, counter.tally());
    }
}