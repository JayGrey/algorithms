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

            final int minIndex = getMinIndexInRow(array, mid);
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

    public static int[] findMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int fromRow = 0;
        int toRow = matrix.length - 1;

        while (fromRow <= toRow) {
            final int midRow = (fromRow + toRow) / 2;

            final int colIndex = find(matrix[midRow]);
            final int minRowIndex = getMinIndexInColumn(matrix, midRow, colIndex);
            if (midRow == minRowIndex) {
                return new int[]{midRow, colIndex};
            }

            if (minRowIndex < midRow) {
                toRow = midRow - 1;
            } else {
                fromRow = midRow + 1;
            }
        }

        return new int[0];
    }

    private static int getMinIndexInRow(int[] row, int index) {
        if (index > 0) { // has A
            if (index < row.length - 1) { //has C
                return minInRow(row, index); // min (a, b, c)
            } else {
                return row[index - 1] < row[index] ? index - 1 : index;
            }
        } else if (index < row.length - 1) {
            return row[index + 1] < row[index] ? index + 1 : index;
        }

        return index;
    }

    private static int minInRow(int[] row, int index) {
        final int a = row[index - 1];
        final int b = row[index];
        final int c = row[index + 1];

        if (b < a && b < c) {
            return index;
        } else if (a < c) {
            return index - 1;
        } else {
            return index + 1;
        }
    }

    private static int getMinIndexInColumn(int[][] matrix, int row, int column) {
        if (row > 0) { // hasA
            if (row < matrix.length - 1) { // hasC
                return minInColumn(matrix, row, column);// min(a, b, c);
            } else {
                return matrix[row - 1][column] < matrix[row][column] ? row - 1 : row; //min(a, b);
            }
        } else if (row < matrix.length - 1) { // hasC
            return matrix[row + 1][column] < matrix[row][column] ? row + 1 : row;// min(b, c);
        }

        return row;
    }

    private static int minInColumn(int[][] matrix, int row, int column) {
        final int a = matrix[row - 1][column];
        final int b = matrix[row][column];
        final int c = matrix[row + 1][column];

        if (b < a && b < c) {
            return row;
        } else if (a < c) {
            return row - 1;
        } else {
            return row + 1;
        }
    }
}
