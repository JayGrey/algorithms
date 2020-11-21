package org.example.ex._1._1._29;

import java.util.Arrays;

public class Runner {
    public static int rank(int k, int[] array) {
        if (array == null || array.length == 0 || array[0] >= k) {
            return 0;
        }

        if (array[array.length - 1] < k) {
            return array.length;
        }

        int index = Arrays.binarySearch(array, k);

        for (int i = index; i >= 0; i--) {
            if (array[i] < k) {
                return i + 1;
            }
        }

        return 0;
    }

    public static int count(int k, int[] array) {
        if (array == null || array.length == 0 || array[array.length - 1] < k) {
            return 0;
        }

        final int number = rank(k, array);

        if (number == 0 && array[0] == k) {
            int num = 0;
            for (int value : array) {
                if (value == k) {
                    num += 1;
                } else {
                    break;
                }
            }
            return num;
        }

        int num = 0;
        for (int i = number; i < array.length - 1; i++) {
            if (array[i] == k) {
                num += 1;
            } else {
                break;
            }
        }

        return num;
    }
}
