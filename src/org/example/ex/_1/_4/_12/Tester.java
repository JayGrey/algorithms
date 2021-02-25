package org.example.ex._1._4._12;

import edu.princeton.cs.algs4.StdOut;

public class Tester {
    public static void main(String[] args) {
        for (int i = 8; i < Integer.MAX_VALUE/2; i += i) {
            // create array
            final int[] arrayA = new int[i];
            final int[] arrayB = new int[i];
            for (int j = 0; j < i; j++) {
                arrayA[j] = j;
                arrayB[j] = j;
            }

            final long startTime = System.currentTimeMillis();
            PrintSameNumbers.search(arrayA, arrayB);
            StdOut.printf("%8d | %8d%n", i, System.currentTimeMillis() - startTime);
        }
    }
}
