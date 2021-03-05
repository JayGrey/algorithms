package org.example.ex._1._4._18;

public class LocalMinimum {

    public static int find(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int from = 0;
        int to = array.length - 1;

        while (from <= to) {
            final int mid = (from + to) / 2;

            final int minIndex = getMinIndex(array, mid);
            if (mid == minIndex) {
                return mid;
            }

            if (minIndex < mid) {
                to = mid - 1;
            } else {
                from = mid + 1;
            }
        }

        return -1;
    }

    private static int getMinIndex(int[] array, int index) {
        if (index > 0) { // has A
            if (index < array.length - 1) { //has C
                // min (a, b, c)
                if (array[index] < array[index - 1] && array[index] < array[index + 1]) {
                    return index;
                } else if (array[index - 1] < array[index + 1]) {
                    return index - 1;
                } else {
                    return index + 1;
                }
            } else {
                return array[index - 1] < array[index] ? index - 1 : index;
            }
        } else if (index < array.length - 1) {
            return array[index + 1] < array[index] ? index + 1 : index;
        }

        return index;
    }
}
