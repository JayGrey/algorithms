package org.example.ex._1._4._14;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FourSum {
    public static int countQuadNumber(int[] array) {
        int result = 0;

        final int N = array.length;

        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    final int partialSum = array[i] + array[j] + array[k];
                    final int key = Arrays.binarySearch(array, -partialSum);
                    if (key > k) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
