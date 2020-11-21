package org.example.ex._1._1._11;


public class Runner {
    static String transposedMatrixToString(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        // draw header
        result.append("   ");
        for (int i = 0; i < matrix.length; i++) {
            result.append(String.format("%2d", i + 1));
        }
        result.append(System.lineSeparator());

        // draw line
        result.append("   ").append(repeat("-", 2 * matrix.length)).append(System.lineSeparator());

        // draw table
        for (int i = 0; i < matrix[0].length; i++) {
            result.append(String.format("%2d|", i + 1));
            for (int j = 0; j < matrix.length; j++) {
                result.append(String.format("%2d", matrix[j][i]));
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }

    static String matrixToString(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();

        // draw header
        result.append("   ");
        for (int i = 0; i < matrix[0].length; i++) {
            result.append(String.format("%2d", i + 1));
        }
        result.append(System.lineSeparator());

        // draw line
        result.append("   ").append(repeat("-", 2 * matrix[0].length)).append(System.lineSeparator());

        // draw table
        for (int i = 0; i < matrix.length; i++) {
            result.append(String.format("%2d|", i + 1));
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(String.format("%2s", matrix[i][j] ? "*" : ""));
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

    private static String repeat(String val, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(val);
        }

        return result.toString();
    }
}
