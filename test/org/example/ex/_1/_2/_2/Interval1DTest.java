package org.example.ex._1._2._2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Interval1DTest {

    @Test
    void intersectsTest() {
        Interval1D a = new Interval1D(1, 2);
        Interval1D b = new Interval1D(2, 4);
        assertTrue(a.intersects(b));
        assertTrue(b.intersects(a));

        a = new Interval1D(1, 3);
        b = new Interval1D(2, 4);
        assertTrue(a.intersects(b));
        assertTrue(b.intersects(a));

        a = new Interval1D(1, 3);
        b = new Interval1D(1, 3);
        assertTrue(a.intersects(b));
        assertTrue(b.intersects(a));

        a = new Interval1D(2, 5);
        b = new Interval1D(5, 2);
        assertTrue(a.intersects(b));
        assertTrue(b.intersects(a));

        a = new Interval1D(1, 4);
        b = new Interval1D(2, 3);
        assertTrue(a.intersects(b));
        assertTrue(b.intersects(a));
    }

    @Test
    public void noIntersectsTest() {
        Interval1D a = new Interval1D(1, 2);
        Interval1D b = new Interval1D(3, 4);
        assertFalse(a.intersects(b));
        assertFalse(b.intersects(a));
    }

    @Test
    void containsTest() {
        Interval1D a = new Interval1D(1, 3);
        Interval1D b = new Interval1D(1, 3);
        assertTrue(a.contains(b));
        assertTrue(b.contains(a));

        a = new Interval1D(1, 4);
        b = new Interval1D(2, 3);
        assertFalse(a.contains(b));
        assertTrue(b.contains(a));

        a = new Interval1D(1, 4);
        b = new Interval1D(1, 3);
        assertFalse(a.contains(b));
        assertTrue(b.contains(a));

        a = new Interval1D(1, 4);
        b = new Interval1D(2, 4);
        assertFalse(a.contains(b));
        assertTrue(b.contains(a));
    }

    @Test
    public void noContainsTest() {
        Interval1D a = new Interval1D(1, 2);
        Interval1D b = new Interval1D(3, 4);
        assertFalse(a.contains(b));
        assertFalse(b.contains(a));

        a = new Interval1D(1, 2);
        b = new Interval1D(2, 4);
        assertFalse(a.contains(b));
        assertFalse(b.contains(a));

        a = new Interval1D(1, 3);
        b = new Interval1D(2, 4);
        assertFalse(a.contains(b));
        assertFalse(b.contains(a));
    }
}