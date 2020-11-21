package org.example.ex._1._1._27;

import java.util.Arrays;

public class Runner {
    public static double binomial(int N, int k, double p, int depth, String comment, double[][] buffer) {
        final String ident = repeat("    ", depth);
//        System.out.format("%sbinomial(%d, %d, %f) %s %n", ident, N, k, p, comment);

        if (N == 0 || k < 0) {
            return 1.0;
        }

        final double val = buffer[N][k];
        if (!Double.isNaN(val)) {
            return val;
        }

        double result = ((1.0 - p) * binomial(N - 1, k, p, depth + 1, "L", buffer))
                + (p * binomial(N - 1, k - 1, p, depth + 1, "R", buffer));

        buffer[N][k] = result;

        return result;
    }

    private static void printMatrix(double[][] arr) {
        for (double[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        System.out.println();

        final int N = 4;
        final int k = 1;

        double[][] buffer = new double[N + 1][k + 1];
        for (double[] row : buffer) {
            Arrays.fill(row, Double.NaN);
        }

        System.out.println(System.lineSeparator() + "answer binomial: " + binomial(N, k, 0.3, 0, "", buffer));
        printMatrix(buffer);
    }

    private static String repeat(String val, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(val);
        }

        return result.toString();
    }
}
