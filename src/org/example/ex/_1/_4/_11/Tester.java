package org.example.ex._1._4._11;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Tester {
    public static void main(String[] args) {
        long previousTime = 1;
        for (int N = 8; N < Integer.MAX_VALUE - 1; N += N) {

            final int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = StdRandom.uniform(-1000, 1000);
            }
            array[0] = 0;
            final StaticSETofInts set = new StaticSETofInts(array);

            final long startTime = System.currentTimeMillis();

            assert set.contains(0);

            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%9d | %8d | %f%n", N, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }
}

