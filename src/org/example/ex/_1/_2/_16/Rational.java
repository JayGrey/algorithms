package org.example.ex._1._2._16;

import java.util.Objects;

public class Rational {
    private static final Rational ZERO_RATIONAL = new Rational(0, 1);
    private static final Rational ONE_RATIONAL = new Rational(1, 1);

    private final long numerator;
    private final long denominator;

    private Rational(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Rational of(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator is equal to zero");
        }

        if (numerator == 0) {
            return ZERO_RATIONAL;
        }

        if (numerator == 1 && denominator == 1) {
            return ONE_RATIONAL;
        }

        long gcd = gcd(numerator, denominator);

        return new Rational(numerator / gcd, denominator / gcd);
    }

    private static long gcd(long p, long q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    public Rational plus(Rational b) {
        Objects.requireNonNull(b);

        if (denominator == b.denominator) {
            return Rational.of(numerator + b.numerator, denominator);
        }

        return Rational.of(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
    }

    public Rational minus(Rational b) {
        Objects.requireNonNull(b);

        if (denominator == b.denominator) {
            return Rational.of(numerator - b.numerator, denominator);
        }

        return Rational.of(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);

    }

    public Rational times(Rational b) {
        Objects.requireNonNull(b);
        if (b == ZERO_RATIONAL) {
            return ZERO_RATIONAL;
        }

        return of(numerator * b.numerator, denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        Objects.requireNonNull(b);

        return of(numerator * b.denominator, denominator * b.numerator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != Rational.class) {
            return false;
        }

        final Rational that = (Rational) obj;

        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerator, denominator);
    }
}
