package org.example.ex._1._5._22;

import edu.princeton.cs.algs4.StdOut;
import org.example.ex._1._5._13.WeightedQuickUnionWithPathCompressionUF;
import org.example.ex._1._5._17.ErdosRenyi;
import org.example.ex._1._5._7.QuickFindUF;
import org.example.ex._1._5._7.QuickUnionUF;
import org.example.ex._1._5._7.WeightedQuickUnionUF;

public class Tester {
    public static void main(String[] args) {
        int MAX_VALUE = 200_000;

        long previousDiffTime = 1L;
        StdOut.println("QuickFindUF");
        for (int N = 8; N < MAX_VALUE; N += N) {
            final long startTime = System.currentTimeMillis();
            ErdosRenyi.count(N, new QuickFindUF(N));
            final long endTime = System.currentTimeMillis();
            StdOut.printf("N: %8d, time: %8d, ratio: %f%n", N, endTime - startTime, (endTime - startTime) / (1.0 * previousDiffTime));
            previousDiffTime = Math.max(1L, endTime - startTime);
        }

        previousDiffTime = 1L;
        StdOut.println();
        StdOut.println("QuickUnionUF");
        for (int N = 8; N < MAX_VALUE; N += N) {
            final long startTime = System.currentTimeMillis();
            ErdosRenyi.count(N, new QuickUnionUF(N));
            final long endTime = System.currentTimeMillis();
            StdOut.printf("N: %8d, time: %8d, ratio: %f%n", N, endTime - startTime, (endTime - startTime) / (1.0 * previousDiffTime));
            previousDiffTime = Math.max(1L, endTime - startTime);
        }

        previousDiffTime = 1L;
        StdOut.println();
        StdOut.println("WeightedQuickUnionUF");
        for (int N = 8; N < MAX_VALUE; N += N) {
            final long startTime = System.currentTimeMillis();
            ErdosRenyi.count(N, new WeightedQuickUnionUF(N));
            final long endTime = System.currentTimeMillis();
            StdOut.printf("N: %8d, time: %8d, ratio: %f%n", N, endTime - startTime, (endTime - startTime) / (1.0 * previousDiffTime));
            previousDiffTime = Math.max(1L, endTime - startTime);
        }

        previousDiffTime = 1L;
        StdOut.println();
        StdOut.println("WeightedQuickUnionWithPathCompressionUF");
        for (int N = 8; N < MAX_VALUE; N += N) {
            final long startTime = System.currentTimeMillis();
            ErdosRenyi.count(N, new WeightedQuickUnionWithPathCompressionUF(N));
            final long endTime = System.currentTimeMillis();
            StdOut.printf("N: %8d, time: %8d, ratio: %f%n", N, endTime - startTime, (endTime - startTime) / (1.0 * previousDiffTime));
            previousDiffTime = Math.max(1L, endTime - startTime);
        }
    }
}
