package org.example.ex._1._4._18;

import edu.princeton.cs.algs4.StdOut;

public class LocalMinimumTester {
    public static void main(String[] args) {

//        runTester();
        runMatrixTester();
    }

    private static void runTester() {
        long previousTime = 1;
        for (int i = 8; i < Integer.MAX_VALUE / 2; i += i) {

            final int[] array = new int[i];
            for (int j = 0; j < array.length; j++) {
                array[j] = array.length - j - 1;
            }
            final int tmp = array[array.length - 1];
            array[array.length - 1] = array[array.length - 2];
            array[array.length - 2] = tmp;
//            StdRandom.shuffle(array);

            final long startTime = System.currentTimeMillis();
            LocalMinimum.find(array);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%9d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }

    private static void runMatrixTester() {
        long previousTime = 1;
        for (int N = 8; N < 16384 * 2 + 1; N += N) {

            int[][] matrix = new int[N][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = new int[N];

                for (int j = 0; j < N; j++) {
                    matrix[i][j] = i * N + j;
                }
            }

            final long startTime = System.currentTimeMillis();
            LocalMinimum.findMatrix(matrix);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%9d | %8d | %f%n", N, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }

    }
}
