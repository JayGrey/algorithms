package org.example.ex._1._4._20;

public class BitonicSearch {
    public static int find(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        final int lmaxIndex = findLocalMaximum(array);
        if (array[lmaxIndex] == key) {
            return lmaxIndex;
        }

        int index = rank(array, 0, lmaxIndex - 1, key);
        return index != -1 ? index : reversedRank(array, lmaxIndex + 1, array.length - 1, key);
    }

    private static int findLocalMaximum(int[] array) {
        int from = 0;
        int to = array.length - 1;

        while (from <= to) {
            final int mid = (from + to) / 2;

            int maxIndex = getMaxIndex(array, mid);
            if (maxIndex == mid) {
                return mid;
            } else if (maxIndex < mid) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }

        return -1;
    }

    private static int getMaxIndex(int[] array, int index) {
        final int a = array[index - 1];
        final int b = array[index];
        final int c = array[index + 1];

        if (b > a && b > c) {
            return index;
        } else if (a > c) {
            return index - 1;
        } else {
            return index + 1;
        }
    }

    private static int rank(int[] array, int from, int to, int key) {
        while (from <= to) {
            final int mid = (from + to) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }

        return -1;
    }

    private static int reversedRank(int[] array, int from, int to, int key) {
        while (from <= to) {
            final int mid = (from + to) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }

        return -1;
    }
}
