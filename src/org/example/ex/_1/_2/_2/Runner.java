package org.example.ex._1._2._2;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

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

}
