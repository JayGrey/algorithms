package org.example.ex._1._4._18;

public class LocalMinimum {

    public static int find(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }

        return findLocalMinimum(array, 0, array.length - 1);
    }

    private static int findLocalMinimum(int[] array, int from, int to) {
        if (to <= from || (to - from + 1) < 3) {
            return -1;
        }

        final int mid = (from + to) / 2;
        if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
            return mid;
        }

        final int result = findLocalMinimum(array, from, mid);
        return result != -1 ? result : findLocalMinimum(array, mid, to);
    }
}
