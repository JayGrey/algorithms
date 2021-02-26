package org.example.ex._1._4._15;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeSumTester {
    public static void main(String[] args) {

        long previousTime = 1;
        for (int i = 8; i < 268_435_456; i += i) {

            final int[] array = new int[i];

            for (int j = 0; j < array.length; j++) {
                array[j] = StdRandom.uniform(-1_000_000, 1_000_000);
            }

            final long startTime = System.currentTimeMillis();
            ThreeSumFaster.count(array);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%8d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }
}
