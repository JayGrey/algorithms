package org.example.ex._1._4._3;

public class TwoSum {
    int count(int[] array) {
        final int N = array.length;

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                final long sum = (long) array[i] + (long) array[j];
                if (sum == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
