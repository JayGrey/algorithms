package org.example.ex._1._4._18;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class LocalMinimumTester {
    public static void main(String[] args) {

        runTester();
//        LocalMinimum.find(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0, 16});
//        LocalMinimum.find(new int[]{-8, -7, -6, -5, -4, -3, -2, 8, 0, 9});
    }

    private static void runTester() {
        long previousTime = 1;
        for (int i = 8; i < Integer.MAX_VALUE / 2; i += i) {

            final int[] array = new int[i];
            for (int j = 0; j < array.length; j++) {
                array[j] = j;
            }
            final int tmp = array[array.length - 3];
            array[array.length - 3] = array[array.length - 2];
            array[array.length - 2] = tmp;
//            StdRandom.shuffle(array);

            final long startTime = System.currentTimeMillis();
            LocalMinimum.find(array);
            final long endTime = System.currentTimeMillis();
            final long currentTime = Math.max(1, endTime - startTime);
            StdOut.printf("%9d | %8d | %f%n", i, currentTime, currentTime / (previousTime * 1.0));
            previousTime = currentTime;
        }
    }
}
