package org.example.ex._1._2._3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Interval2DTest {

    @Test
    public void intersectTest() {
        // case1
        Interval2D interval1 = new Interval2D(1, 2, 3, 4);
        Interval2D interval2 = new Interval2D(2, 1, 4, 3);
        assertTrue(interval1.intersects(interval2));
        assertTrue(interval2.intersects(interval1));

        // case 2
        interval1 = new Interval2D(1, 2, 3, 4);
        interval2 = new Interval2D(1, 1, 3, 3);
        assertTrue(interval1.intersects(interval2));
        assertTrue(interval2.intersects(interval1));

        // case 3
        interval1 = new Interval2D(1, 1, 3, 3);
        interval2 = new Interval2D(2, 2, 4, 4);
        assertTrue(interval1.intersects(interval2));
        assertTrue(interval2.intersects(interval1));

        // case 4
        interval1 = new Interval2D(1, 1, 3, 3);
        interval2 = new Interval2D(2, 1, 4, 3);
        assertTrue(interval1.intersects(interval2));
        assertTrue(interval2.intersects(interval1));

        // case 5
        interval1 = new Interval2D(1, 1, 3, 3);
        interval2 = new Interval2D(1, 1, 3, 3);
        assertTrue(interval1.intersects(interval2));
        assertTrue(interval2.intersects(interval1));
    }

    @Test
    public void noIntersectTest() {
        // case 1
        Interval2D a = new Interval2D(1, 3, 2, 4);
        Interval2D b = new Interval2D(3, 1, 4, 2);
        assertFalse(a.intersects(b));
        assertFalse(b.intersects(a));

        // case 2
        a = new Interval2D(1, 3, 2, 4);
        b = new Interval2D(1, 1, 2, 2);
        assertFalse(a.intersects(b));
        assertFalse(b.intersects(a));

        // case 3
        a = new Interval2D(1, 1, 2, 2);
        b = new Interval2D(3, 3, 4, 4);
        assertFalse(a.intersects(b));
        assertFalse(b.intersects(a));

        // case 4
        a = new Interval2D(1, 1, 2, 2);
        b = new Interval2D(3, 1, 4, 2);
        assertFalse(a.intersects(b));
        assertFalse(b.intersects(a));
    }

    @Test
    public void containsTest() {
        Interval2D a = new Interval2D(1, 1, 3, 3);
        Interval2D b = new Interval2D(1, 1, 3, 3);
        assertTrue(a.contains(b));
        assertTrue(b.contains(a));

        a = new Interval2D(1, 1, 4, 4);
        b = new Interval2D(2, 2, 3, 3);
        assertFalse(a.contains(b));
        assertTrue(b.contains(a));
    }
}