package org.example.ex._1._1._36;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.function.Consumer;

public class Runner {

    public static void main(String[] args) {
        final int N = 100_000;
        final int M = 10;

        printMatrix(shuffleTest(M, N, Runner::shuffle), N);
        StdOut.println();
        printMatrix(shuffleTest(M, N, Runner::badShuffle), N);
    }

    private static void printMatrix(int[][] matrix, final int N) {
        final int pos = (int) Math.ceil(Math.log10(N)) + 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                StdOut.printf("%" + pos + "d", matrix[i][j]);
            }
            StdOut.println();
        }
    }

    public static void shuffle(int[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void badShuffle(int[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(N);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * @param N number of shuffles
     * @param M array size
     * @return test result
     */
    public static int[][] shuffleTest(final int M, final int N, Consumer<int[]> shuffleFunction) {
        int[][] result = new int[M][M];

        int[] array = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[j] = j;
            }

            shuffleFunction.accept(array);

            for (int j = 0; j < M; j++) {
                final int k = array[j];
                result[k][j] += 1;
            }
        }

        return result;
    }
}
