package org.example.ex._1._2._2;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final Runner runner = new Runner();

        Interval1D[] intervals = runner.getIntervals(N, 0.0, 10.0);
        runner.printIntersectedIntervals(intervals);
    }

    private void printIntersectedIntervals(Interval1D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                final Interval1D interval1 = intervals[i];
                final Interval1D interval2 = intervals[j];
                if (interval1.intersects(interval2)) {
                    StdOut.printf("%s intersects with %s%n", interval1, interval2);
                }
            }
        }
    }

    Interval1D[] getIntervals(int N, double min, double max) {
        final Interval1D[] result = new Interval1D[N];

        for (int i = 0; i < result.length; i++) {
            final double intervalLeft = StdRandom.uniform(min, max);
            final double intervalRight = StdRandom.uniform(min, max);

            result[i] = new Interval1D(intervalLeft, intervalRight);
        }

        return result;
    }

    static class Interval1D {
        private final double left;
        private final double right;

        public Interval1D(double left, double right) {
            this.left = Math.min(left, right);
            this.right = Math.max(left, right);
        }

        public boolean intersects(Interval1D other) {
            return other != null && (right >= other.left || other.right >= left);
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
}
