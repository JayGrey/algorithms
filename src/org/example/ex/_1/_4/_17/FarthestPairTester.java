package org.example.ex._1._4._17;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class FarthestPairTester {
    public static void main(String[] args) {
        long previousTime = 1;
        for (int i = 8; i < 268_435_456; i += i) {

            final double[] array = new double[i];

            for (int j = 0; j < array.length; j++) {
                array[j] = StdRandom.uniform(Double.MIN_VALUE, Double.MAX_VALUE);
            }

            final long startTime = System.currentTimeMillis();
            FarthestPair.find(array);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%8d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }
}
