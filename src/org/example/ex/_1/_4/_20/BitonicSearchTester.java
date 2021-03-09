package org.example.ex._1._4._20;

import edu.princeton.cs.algs4.StdOut;

public class BitonicSearchTester {
    public static void main(String[] args) {
        long previousTime = 1;
        for (int N = 8; N < Integer.MAX_VALUE / 2; N += N) {

            final int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = i;
            }
            final int temp = array[array.length - 2];
            array[array.length - 2] = array[array.length - 1];
            array[array.length - 1] = temp;

            final long startTime = System.currentTimeMillis();
            BitonicSearch.find(array, 0);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%9d | %8d | %f%n", N, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }
}
