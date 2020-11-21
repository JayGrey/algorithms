package org.example.ex._1._1._31;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Runner {
    public static void main(String[] args) {
        final int N = Integer.parseInt(args[0]);
        final double p = Double.parseDouble(args[1]);

        double[] xCoords = new double[N];
        double[] yCoords = new double[N];

        final int SCALE = 10;

        StdDraw.setXscale(0, SCALE);
        StdDraw.setYscale(0, SCALE);
        StdDraw.setPenRadius(0.005);

        // draw dots
        for (int i = 0; i < N; i++) {
            final double angle = ((2 * Math.PI) / N) * i;
            final double x = (Math.cos(angle) + (SCALE / 2.0)) ;
            final double y = (Math.sin(angle) + (SCALE / 2.0)) ;

            StdDraw.point(x, y);

            xCoords[i] = x;
            yCoords[i] = y;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (StdRandom.bernoulli(p)) {
                    StdDraw.line(xCoords[i], yCoords[i], xCoords[j], yCoords[j]);
                }
            }
        }


    }
}
