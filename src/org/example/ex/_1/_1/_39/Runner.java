package org.example.ex._1._1._39;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Runner {
    private static final int T = 10;
    private static final int N = 1_000_000;

    public static int rank(int key, int[] a) {

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            final int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] array1 = new int[N];
        final int[] array2 = new int[N];

        final int minNumber = 100_000;
        final int maxNumber = 1_000_000;

        final int[] result = new int[T];

        for (int i = 0; i < T; i++) {

            for (int j = 0; j < N; j++) {
                array1[j] = StdRandom.uniform(minNumber, maxNumber);
                array2[j] = StdRandom.uniform(minNumber, maxNumber);
            }

            int count = 0;
            Arrays.sort(array1);
            Arrays.sort(array2);
            for (int j = 0; j < array1.length; j++) {
                if (j > 0 && array1[j] == array1[j - 1]) {
                    continue;
                }

                if (rank(array1[j], array2) > 0) {
                    count++;
                }
            }

            result[i] = count;
        }

        long sum = 0;
        for (int j : result) {
            sum += j;
        }
        StdOut.printf("N = %d, T = %d, avg = %d%n", N, T, sum / result.length);
    }
}
