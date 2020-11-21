package org.example.ex._1._1._26;

import java.util.Arrays;
import java.util.Objects;

public class Runner {
    public static void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("argument is null");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                min(arr, i, j);
            }
        }
    }

    private static void min(int[] arr, int i, int j) {
        if (arr[i] > arr[j]) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {2, 1, 4, 3};
        System.out.println("before: " + Arrays.toString(array));

        sort(array);

        System.out.println("after: " + Arrays.toString(array));
    }
}
