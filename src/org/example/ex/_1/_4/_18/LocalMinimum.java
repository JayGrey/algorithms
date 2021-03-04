package org.example.ex._1._4._18;

public class LocalMinimum {

    public static int find(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }

        int result = findLocal(array, SearchDirection.ASCENDING, 0, array.length - 1);
        return result != -1 ? result : findLocal(array, SearchDirection.DESCENDING, 0, array.length - 1);
    }

    public static int findLinear(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }

        final int to = array.length - 2;
        for (int i = 1; i <= to; i++) {
            if (array[i] < array[i - 1] && array[i] < array[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    private static int findLocal(int[] array, SearchDirection direction, int from, int to) {
        final int mid = (from + to) / 2;

        if (from > to || mid == 0 || mid == array.length - 1) {
            return -1;
        }

        if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
            return mid;
        }

        if (direction == SearchDirection.DESCENDING) {
            return array[mid - 1] < array[mid + 1]
                    ? findLocal(array, direction, from, mid - 1)
                    : findLocal(array, direction, mid + 1, to);

        } else if (direction == SearchDirection.ASCENDING) {
            return array[mid - 1] > array[mid + 1]
                    ? findLocal(array, direction, from, mid - 1)
                    : findLocal(array, direction, mid + 1, to);
        }

        return -1;
    }

    private enum SearchDirection {ASCENDING, DESCENDING}
}
