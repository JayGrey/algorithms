package org.example.ex._1._4._22;

public class FibonacciSearch {
    public static int find(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        final int[] fibNumbers = getFibNumbers(array.length);
        int offset = 0;
        while (fibNumbers[0] >= 0) {
            final int index = Math.min(array.length - 1, fibNumbers[0] + offset);

            if (array[index] == key) {
                return index;
            } else if (array[index] < key) {
                offset += fibNumbers[0];
                decreaseFibNumbersBy(fibNumbers, 1);
            } else {
                decreaseFibNumbersBy(fibNumbers, 2);
            }
        }

        return -1;
    }

    private static int[] getFibNumbers(int n) {
        int[] result = {0, 1, 1};

        while (n > result[2]) {
            final int tmp = result[1] + result[2];
            result[0] = result[1];
            result[1] = result[2];
            result[2] = tmp;
        }

        return result;
    }

    private static void decreaseFibNumbersBy(int[] fibNumbers, int amount) {
        while (amount-- > 0) {
            final int tmp = fibNumbers[1] - fibNumbers[0];
            fibNumbers[2] = fibNumbers[1];
            fibNumbers[1] = fibNumbers[0];
            fibNumbers[0] = tmp;
        }
    }
}
