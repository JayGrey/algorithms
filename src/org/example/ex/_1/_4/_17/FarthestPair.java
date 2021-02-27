package org.example.ex._1._4._17;

public class FarthestPair {
    public static double[] find(double[] array) {
        if (array == null || array.length < 2) {
            return new double[0];
        }

        final double[] result = new double[2];
        result[0] = Math.min(array[0], array[1]);
        result[1] = Math.max(array[0], array[1]);

        final int N = array.length;
        for (int i = 2; i < N; i++) {
            if (array[i] < result[0]) {
                result[0] = array[i];
            } else if (array[i] > result[1]) {
                result[1] = array[i];
            }
        }

        return result;
    }
}
