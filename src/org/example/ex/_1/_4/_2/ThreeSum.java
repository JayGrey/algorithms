package org.example.ex._1._4._2;

public class ThreeSum {
    public static int count(int[] a) {
        final int N = a.length;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    final long sum = (long) a[i] + (long) a[j] + (long) a[k];
                    if (sum == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
