package org.example.ex._1._1._30;

public class Runner {
    public static boolean[][] createArray(int N) {
        if (N < 1) {
            return new boolean[0][0];
        }

        boolean[][] result = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i][j] = gcd(i + 1, j + 1) != 1;
            }
        }
        return result;
    }

    public static int gcd(int p, int q) {
        return q == 0 ? p : gcd(q, p % q);
    }

    public static void printArray(boolean[][] array) {
        for (boolean[] row : array) {
            for (boolean cell : row) {
                System.out.print(" " + (cell ? 'X' : '.'));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printArray(createArray(20));
    }
}
