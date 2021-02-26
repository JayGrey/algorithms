package org.example.ex._1._4._14;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Tester {
    public static void main(String[] args) {
        for (int i = 8; i < 1024 * 1024; i += i) {
            final int[] array = new int[i];

            for (int j = 0; j < array.length; j++) {
                array[j] = StdRandom.uniform(-1000000, 1000000);
            }

            final long startTime = System.currentTimeMillis();
            FourSum.countQuadNumber(array);
            StdOut.printf("%5d | %5d%n", i, System.currentTimeMillis() - startTime);

        }
    }
}
