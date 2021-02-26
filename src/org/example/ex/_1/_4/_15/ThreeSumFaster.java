package org.example.ex._1._4._15;

import java.util.Arrays;

public class ThreeSumFaster {
    public static int count(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Arrays.sort(array);

        int result = 0;
        final int N = array.length;
        for (int i = 0; i < N - 2; i++) {
            result += count2sum(array, i + 1, array[i]);
        }

        return result;
    }

    private static int count2sum(int[] array, int from, int addition) {

        int result = 0;
        int indexA = from;
        int indexB = array.length - 1;

        while (indexA < indexB) {
            final int a = array[indexA] + addition;
            indexB = getFromEndNoMoreThan(array, indexB, from, -a);
            if (indexB > indexA && a == -array[indexB]) {
                result++;
                indexB--;
            }

            indexA++;
        }
        return result;
    }

    private static int getFromEndNoMoreThan(int[] array, int from, int to, int key) {
        for (int i = from; i >= to; i--) {
            if (array[i] <= key) {
                return i;
            }
        }
        return -1;
    }
}
