package org.example.ex._1._2._16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    @Test
    public void equalsTest() {
        assertEquals(Rational.of(1, 2), Rational.of(2, 4));
        assertEquals(Rational.of(1, 2), Rational.of(1, 2));
    }

    @Test
    public void plus() {
        assertEquals(Rational.of(1, 1), Rational.of(1, 2).plus(Rational.of(1, 2)));
    }

    @Test
    public void minus() {
        assertEquals(Rational.of(1, 2), Rational.of(1, 1).minus(Rational.of(1, 2)));
    }

    @Test
    public void times() {
        assertEquals(Rational.of(1, 4), Rational.of(1, 2).times(Rational.of(1, 2)));
        assertEquals(Rational.of(8, 15), Rational.of(2, 3).times(Rational.of(4, 5)));
    }

    @Test
    public void divides() {
        assertEquals(Rational.of(1, 2), Rational.of(1, 1).divides(Rational.of(2, 1)));;
    }
}