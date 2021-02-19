package org.example.ex._1._4._8;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._3._19.LinkedList;

import java.util.Arrays;
import java.util.function.Function;

public class EqualPairsSum {
    public static void main(String[] args) {
        doubleTest(32, 1_024_000, EqualPairsSum::countEqualPair);
    }

    private static void doubleTest(int startFrom, int endTo, Function<int[], Integer> function) {
        // prepare input data
        int minValue = -1_000_000;
        int maxValue = 1_000_000;

        for (int n = startFrom; n < endTo; n += n) {
            final int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = StdRandom.uniform(minValue, maxValue);
            }

            final long timeStart = System.currentTimeMillis();
            final int matchedPairs = function.apply(array);
            StdOut.printf("%8d | %8d %n", n, System.currentTimeMillis() - timeStart);
        }

    }

    public static int countEqualPair(int[] array) {

        int totalCount = 0;
        Arrays.sort(array);
        final DataHolder[] dataArray = distinct(array);

        for (int i = 0; i < dataArray.length; i++) {

            if ((dataArray[i].number / 2) > 1) {
                totalCount += dataArray[i].number / 2;
            }

            for (int j = i + 1; j < dataArray.length; j++) {
                totalCount += Math.min(dataArray[i].number, dataArray[j].number);
            }
        }

        return totalCount;
    }

    private static DataHolder[] distinct(int[] array) {
        if (array == null || array.length == 0) {
            return new DataHolder[0];
        }

        final LinkedList<DataHolder> list = new LinkedList<>();

        DataHolder buffer = new DataHolder(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == buffer.value) {
                buffer.inc();
            } else {
                if (buffer.number > 1) {
                    list.add(buffer);
                }
                buffer = new DataHolder(array[i]);
            }
        }
        if (buffer.number > 1) {
            list.add(buffer);
        }

        final DataHolder[] result = new DataHolder[list.size()];

        int i = 0;
        for (DataHolder item : list) {
            result[i++] = item;
        }

        return result;
    }

    private static final class DataHolder {
        private final int value;
        private int number;

        public DataHolder(int value) {
            this.value = value;
            this.number = 1;
        }

        public void inc() {
            number++;
        }
    }
}
