package org.example.ex._1._4._10;

import edu.princeton.cs.algs4.StdOut;

public class Tester {
    private static final int MAX_LENGTH = 10_000_000;


    public static void main(String[] args) {
        for (int i = 8; i < MAX_LENGTH; i += i) {

            final int[] array = new int[i];

            final long startTime = System.currentTimeMillis();

            assert Search.smallestRank(array, 0) == 0;

            StdOut.printf("%5d | %5d%n", i, System.currentTimeMillis() - startTime);
        }
    }
}

