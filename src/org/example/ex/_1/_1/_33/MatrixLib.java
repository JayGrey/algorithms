package org.example.ex._1._1._33;

public class MatrixLib {
    /**
     * vector dot product
     */
    public static double dot(double[] x, double[] y) {
        if (x == null || y == null || x.length != y.length) {
            throw new IllegalArgumentException();
        }

        double result = 0.0;
        for (int i = 0; i < x.length; i++) {
            result += (x[i] * y[i]);
        }
        return result;
    }

    /**
     * matrix-matrix product
     */
    static double[][] mult(double[][] a, double[][] b) {

        if (a == null || b == null || a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        final double[][] result = new double[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {

                double c = 0.0;
                for (int k = 0; k < b.length; k++) {
                    c += (a[i][k] * b[k][j]);
                }
                result[i][j] = c;
            }
        }

        return result;
    }

    /**
     * transpose
     */
    static double[][] transpose(double[][] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }

        double[][] result = new double[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j][i] = a[i][j];
            }
        }

        return result;
    }

    /**
     * matrix-vector product
     */
    static double[] mult(double[][] a, double[] x) {
        if (a == null || x == null || a[0].length != x.length) {
            throw new IllegalArgumentException();
        }

        double[] result = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < x.length; j++) {
                result[i] += (a[i][j] * x[j]);
            }
        }

        return result;
    }

    /**
     * vector-matrix product
     */
    static double[] mult(double[] y, double[][] a) {
        if (y == null || a == null || y.length != a.length) {
            throw new IllegalArgumentException();
        }

        final double[] result = new double[a[0].length];

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i] += y[j] * a[j][i];
            }
        }

        return result;
    }
}
