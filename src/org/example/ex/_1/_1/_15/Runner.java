package org.example.ex._1._1._15;

public class Runner {
    public static int[] histogram(int[] a, int M) {
        if (M <= 0) {
            return new int[0];
        }

        if (a == null || a.length == 0) {
            return new int[M];
        }

        int[] result = new int[M];

        for (int elem : a) {
            if (elem < M) {
                result[elem] += 1;
            }
        }

        return result;
    }
}
