package org.example.ex._1._1._28;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Runner {
    public static int rank(int[] array, int key) {

        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            final int mid = lo + (hi - lo) / 2;
            if (key < array[mid]) {
                hi = mid - 1;
            } else if (key > array[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        /*
        final String whiteListFile = "tinyAllowlist.txt";
        final String tinyText = "tinyText.txt";
        */

        final String whiteListFile = "largeAllowlist.txt";
        final String tinyText = "largeText.txt";

        int[] whiteList1 = readIntFile(whiteListFile);
        int[] whiteList2 = new int[whiteList1.length];
        System.arraycopy(whiteList1, 0, whiteList2, 0, whiteList1.length);

//        Arrays.sort(whiteList1);

        long start = System.currentTimeMillis();
        int[] result = removeDuplicates1(whiteList2);
        System.out.println("removeDuplicates1, size: " + whiteList2.length + " finished: " + (System.currentTimeMillis() - start) + " result: " + result.length);

        start = System.currentTimeMillis();
        result = removeDuplicates(whiteList1);
        System.out.println("removeDuplicates, size: " + whiteList1.length + " finished: " + (System.currentTimeMillis() - start) + " result: " + result.length);


        start = System.currentTimeMillis();
        int found = 0;
        final int[] intFile = readIntFile(tinyText);
        for (int val : intFile) {
            final int index = rank(whiteList1, val);
            if (index != -1) {
                found += 1;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("processed: " + intFile.length + " found: " + found + " time: " + (end - start));
    }

    /**
     * Remove duplicates in already sorted array
     *
     * @param array sorted array in ascending order
     * @return array without duplicates
     */
    public static int[] removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        if (array.length == 1) {
            return array;
        }

        int removed = 0;
        int i = 0;

        while (i < array.length - removed - 1) {
            if (array[i] == array[i + 1]) {
                removed = removed + 1;
                System.arraycopy(array, i + 1, array, i, array.length - i - removed);
            } else {
                i += 1;
            }
        }

        final int[] result = new int[array.length - removed];
        System.arraycopy(array, 0, result, 0, result.length);

        return result;
    }

    public static int[] removeDuplicates1(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        if (array.length == 1) {
            return array;
        }

        int[] temp = new int[array.length];

        temp[0] = array[0];
        int removed = 0;

        int j = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                temp[++j] = array[i];
            } else {
                removed += 1;
            }
        }

        int[] result = new int[array.length - removed];
        System.arraycopy(temp, 0, result, 0, array.length - removed);

        return result;
    }

    private static int[] readIntFile(String filename) {
        try (final BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().map(String::trim).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
        return new int[]{};
    }
}
