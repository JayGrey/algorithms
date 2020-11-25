package org.example.ex._1._2._2;

import java.util.Objects;

public final class Interval1D {
    private final double left;
    private final double right;

    public Interval1D(double left, double right) {
        this.left = Math.min(left, right);
        this.right = Math.max(left, right);
    }

    public boolean intersects(Interval1D other) {
        return other != null && (right >= other.left && other.right >= left);
    }

    public boolean contains(Interval1D that) {
        return that != null && this.left >= that.left && this.right <= that.right;
    }

    @Override
    public String toString() {
        return String.format("Interval[%f, %f]", left, right);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Interval1D that = (Interval1D) o;
        return Double.compare(that.left, left) == 0 && Double.compare(that.right, right) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
