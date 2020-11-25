package org.example.ex._1._2._3;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Runner {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final double min = Double.parseDouble(args[1]);
        final double max = Double.parseDouble(args[2]);

        final Interval2D[] intervals = new Interval2D[N];

        for (int i = 0; i < N; i++) {
            Point a = getRandomPoint(0.0, 1.0, 0.0, 1.0);
            final double w = StdRandom.uniform(min, max);
            final double h = StdRandom.uniform(min, max);

            intervals[i] = new Interval2D(a, w, h);
        }

        printIntersected2DIntervals(intervals);
        StdOut.println();
        printContained2DIntervals(intervals);
    }

    private static void printIntersected2DIntervals(Interval2D[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return;
        }

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + i; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    StdOut.printf("%s intersects %s%n", intervals[i], intervals[j]);
                }
            }
        }

    }

    private static void printContained2DIntervals(Interval2D[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return;
        }

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + i; j < intervals.length; j++) {
                if (intervals[i].contains(intervals[j])) {
                    StdOut.printf("%s contains %s%n", intervals[i], intervals[j]);
                } else if (intervals[j].contains(intervals[i])) {
                    StdOut.printf("%s contains %s%n", intervals[j], intervals[i]);
                }
            }
        }
    }

    private static Point getRandomPoint(double xMin, double xMax, double yMin, double yMax) {
        return new Point(StdRandom.uniform(xMin, xMax), StdRandom.uniform(yMin, yMax));
    }


}
