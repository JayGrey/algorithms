package org.example.ex._1._4._16;

import java.util.Arrays;

public class ClosestPair {

    public static double[] find(double[] array) {
        if (array == null || array.length < 2) {
            return new double[0];
        }

        Arrays.sort(array);

        final int N = array.length;
        final double[] result = new double[]{array[0], array[1]};
        double minDiff = Math.abs(array[1] - array[0]);

        for (int i = 1; i < N - 1; i++) {
            final double diff = Math.abs(array[i + 1] - array[i]);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = array[i];
                result[1] = array[i + 1];
            }
        }

        return result;
    }
}
