package org.example.ex._1._1._32;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

public class Runner {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final double l = Math.min(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        final double r = Math.max(Double.parseDouble(args[1]), Double.parseDouble(args[2]));

        final Runner runner = new Runner();

        runner.plotHistogram(runner.getNumbersFromStdIn(l, r, N));
//        runner.plotHistogram(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
    }

    int[] getNumbersFromStdIn(double left, double right, int N) {
        final int[] result = new int[N];

        final double step = Math.abs(((right - left) / N));

        final double[] values = StdIn.readAllDoubles();
        for (double value : values) {

            if (value < left || value > right) {
                continue;
            }

            for (int i = 0; i < N; i++) {
                final double l = left + i * step;
                final double r = left + (i + 1) * step;
                if (value >= l && value <= r) {
                    result[i] = result[i] + 1;
                    break;
                }
            }
        }

        return result;
    }

    void plotHistogram(int[] array) {

        final double marginLeft = 2.0;
        final double marginRight = 2.0;
        final double marginTop = 2.0;
        final double marginBottom = 2.0;

        final double stakeWidth = 10.0;
        final double stakeMaxHeight = StdStats.max(array);

        final double scaleXMin = 0.0;
        final double scaleXMax = array.length * stakeWidth + marginLeft + marginRight;
        StdDraw.setXscale(scaleXMin, scaleXMax);
        StdOut.printf("scale x: [%f, %f]%n", scaleXMin, scaleXMax);

        final double scaleYMin = 0.0;
        final double scaleYMax = stakeMaxHeight + marginBottom + marginTop;
        StdDraw.setYscale(scaleYMin, scaleYMax);
        StdOut.printf("scale y: [%f, %f]%n", scaleYMin, scaleYMax);


        for (int i = 0; i < array.length; i++) {
            final double x = marginLeft + i * stakeWidth + stakeWidth / 2;
            final double y = marginBottom + array[i] - array[i] / 2.0;
            final double w = stakeWidth / 2.0;
            final double h = array[i] / 2.0;

            StdOut.printf("stake [x=%f, y=%f, w=%f, h=%f]%n", x, y, w, h);

            StdDraw.filledRectangle(x, y, w, h);
        }
    }
}
