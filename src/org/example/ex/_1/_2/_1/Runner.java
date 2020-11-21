package org.example.ex._1._2._1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Runner {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);

        Point2D[] points = generatePoints(N);

        double distance = calcDistanceBetweenNearestPoints(points);

        StdOut.println("min distance between points is: " + distance);
    }

    private static double calcDistanceBetweenNearestPoints(Point2D[] points) {
        if (points == null || points.length <= 2) {
            return Double.NaN;
        }

        Point2D minA = null;
        Point2D minB = null;

        double result = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                final Point2D a = points[i];
                final Point2D b = points[j];
                final double distance = a.distance(b);
                if (distance < result) {
                    minA = a;
                    minB = b;
                    result = distance;
                }
            }
        }

        drawPoints(points, minA, minB);

        return result;
    }

    private static void drawPoints(Point2D[] points, Point2D minA, Point2D minB) {
        if (points == null || points.length == 0) {
            return;
        }

        StdDraw.setXscale(0.0, 1.0);
        StdDraw.setYscale(0.0, 1.0);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);

        for (Point2D point : points) {
            StdDraw.point(point.x, point.y);
        }

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(minA.x, minA.y);
        StdDraw.point(minB.x, minB.y);
        StdDraw.line(minA.x, minA.y, minB.x, minB.y);
    }

    private static Point2D[] generatePoints(int N) {
        final Point2D[] result = new Point2D[N];

        for (int i = 0; i < result.length; i++) {
            final double x = StdRandom.uniform(0.0, 1.0);
            final double y = StdRandom.uniform(0.0, 1.0);

            result[i] = new Point2D(x, y);
        }

        return result;
    }

    private static class Point2D {
        private final double x;
        private final double y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double distance(Point2D other) {
            if (other == null
                    || !Double.isFinite(other.x) || !Double.isFinite(other.y)
                    || !Double.isFinite(x) || !Double.isFinite(y)) {
                return Double.NaN;
            }

            return Math.sqrt(Math.pow(other.x - x, 2.0) + Math.pow(other.y - y, 2.0));
        }
    }
}
