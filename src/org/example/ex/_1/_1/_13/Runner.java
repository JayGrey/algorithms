package org.example.ex._1._1._13;

import edu.princeton.cs.algs4.StdOut;

public class Runner {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};

        printMatrix(a);
        StdOut.println();
        printTranspositionMatrix(a);
    }

    static void printTranspositionMatrix(int[][] a) {

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                StdOut.printf("%3d", a[j][i]);
            }
            StdOut.println();
        }
    }

    static void printMatrix(int[][] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                StdOut.printf("%3d", a[i][j]);
            }
            StdOut.println();
        }
    }
}
