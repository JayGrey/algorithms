package org.example.ex._1._4._18;

public class LocalMinimum {

    public static int find(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }

        return findLocalMinimum(array, 0, array.length - 1);
    }

    public static int findFirst(int[] array, int from, int to) {
        if (array == null || array.length < 3 || (to - from + 1) < 3) {
            return -1;
        }

        final int mid = (from + to) / 2;
        final int found = (array[mid - 1] > array[mid]) && (array[mid] < array[mid + 1]) ? mid : -1;
        final int other = findFirst(array, from, mid);

        if (found == -1 && other == -1) {
            return findFirst(array, mid, to);
        } else {
            return other == -1 ? found : other;
        }
    }

    private static int findLocalMinimum(int[] array, int from, int to) {
        if (to <= from || (to - from + 1) < 3) {
            return -1;
        }

        final int mid = (from + to) / 2;
        if (array[mid - 1] > array[mid] && array[mid] < array[mid + 1]) {
            return mid;
        }

        final int result = findLocalMinimum(array, from, mid);
        return result != -1 ? result : findLocalMinimum(array, mid, to);
    }

    public static int[] findMatrix(int[][] matrix) {
        final int[] EMPTY_ARRAY = new int[0];

        if (matrix == null) {
            return EMPTY_ARRAY;
        }

        for (int i = 1; i < matrix.length - 1; i++) {

            int from = 0;
            final int to = matrix[i].length - 1;
            while (from < to) {
                final int index = findFirst(matrix[i], from, to);

                if (index == -1) {
                    // not found in this row, go to next row
                    break;
                } else if (matrix[i - 1][index] > matrix[i][index]
                        && matrix[i][index] < matrix[i + 1][index]) {
                    return new int[]{i, index};
                } else {
                    // this local min didn't match, find next
                    from = index + 2;
                }
            }
        }
        return EMPTY_ARRAY;
    }
}
