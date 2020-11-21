package org.example.ex._1._1._33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixLibTest {

    @Test
    void dotTrashData() {
        try {
            MatrixLib.dot(null, null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            MatrixLib.dot(new double[0], null);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            MatrixLib.dot(null, new double[0]);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        try {
            MatrixLib.dot(new double[]{0.0}, new double[0]);
            fail();
        } catch (IllegalArgumentException ignored) {
        }

        // empty arrays
        assertEquals(0.0, MatrixLib.dot(new double[0], new double[0]));
    }

    @Test
    void testDot() {
        assertEquals(10.0, MatrixLib.dot(new double[]{1.0, 2.0, 3.0}, new double[]{3.0, 2.0, 1.0}));
    }

    @Test
    public void testMult() {
        double[][] a = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        double[][] b = new double[][]{{7.0, 8.0}, {9.0, 0.0}, {1.0, 2.0}};

        final double[][] c = MatrixLib.mult(a, b);

        assertEquals(2, c.length);
        assertEquals(2, c[0].length);
        assertArrayEquals(new double[]{28.0, 14.0}, c[0]);
        assertArrayEquals(new double[]{79.0, 44.0}, c[1]);
    }

    @Test
    public void testTranspose() {
        double[][] matrix = new double[][]{{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};

        final double[][] result = MatrixLib.transpose(matrix);

        assertEquals(2, result.length);
        assertArrayEquals(new double[]{1.0, 3.0, 5.0}, result[0]);
        assertArrayEquals(new double[]{2.0, 4.0, 6.0}, result[1]);
    }

    @Test
    public void testMatrixVectorMult() {
        double[][] matrix = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        double[] vector = new double[]{2.0, 1.0, 3.0};

        final double[] result = MatrixLib.mult(matrix, vector);

        assertArrayEquals(new double[]{13.0, 31.0, 49.0}, result);
    }

    @Test
    public void testVectorMatrixMult() {
        double[][] matrix = new double[][]{{1.0, 2.0}, {4.0, 5.0}, {7.0, 8.0}};
        double[] vector = new double[]{2.0, 1.0, 3.0};

        final double[] result = MatrixLib.mult(vector, matrix);

        assertEquals(2, result.length);
        assertArrayEquals(new double[]{27.0, 33.0}, result);
    }
}