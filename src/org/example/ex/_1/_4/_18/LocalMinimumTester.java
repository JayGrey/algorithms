package org.example.ex._1._4._18;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class LocalMinimumTester {
    public static void main(String[] args) {

//        testFind();
//        testFindFirstLocalMinimum();
        testFindFirstLocalMinimumMatrix();
    }

    private static void testFind() {
        long previousTime = 1;
        for (int i = 8; i < Integer.MAX_VALUE - 1; i += i) {

            final int[] array = new int[i];
            for (int j = 0; j < array.length; j++) {
                array[j] = j;
            }
            StdRandom.shuffle(array);

            final long startTime = System.currentTimeMillis();
            LocalMinimum.find(array);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%8d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }

    private static void testFindFirstLocalMinimum() {
        long previousTime = 1;
        for (int i = 8; i < Integer.MAX_VALUE / 2; i += i) {

            final int[] array = new int[i];
            for (int j = 0; j < array.length; j++) {
                array[j] = j;
            }
            StdRandom.shuffle(array);

            final long startTime = System.currentTimeMillis();
            LocalMinimum.findFirst(array, 0, array.length - 1);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%8d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }

    private static void testFindFirstLocalMinimumMatrix() {
        long previousTime = 1;
        for (int i = 8; i < 32768; i += i) {

            final int[][] matrix = new int[i][i];
            for (int j = 0; j < matrix.length; j++) {
                matrix[j] = new int[i];

                for (int k = 0; k < matrix.length; k++) {
                    matrix[j][k] = j * matrix.length + k;
                }
                StdRandom.shuffle(matrix[j]);
            }

            final long startTime = System.currentTimeMillis();
            LocalMinimum.findMatrix(matrix);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%8d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }
}
