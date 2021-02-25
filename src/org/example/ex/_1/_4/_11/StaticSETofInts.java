package org.example.ex._1._4._11;

import java.util.Arrays;

public class StaticSETofInts {
    private final int[] array;

    public StaticSETofInts(int[] keys) {
        this.array = new int[keys.length];
        System.arraycopy(keys, 0, array, 0, keys.length);

        Arrays.sort(array);
    }

    public boolean contains(int key) {
        return rank(key, RankType.EXACT, 0, array.length - 1) != -1;
    }

    public int howMany(int key) {
        final int biggestRank = biggestRank(key);

        if (biggestRank == -1) {
            return 0;
        }

        final int smallestRank = smallestRank(key);

        return biggestRank - smallestRank + 1;
    }

    private int smallestRank(int key) {
        return rank(key, RankType.SMALLEST, 0, array.length - 1);
    }

    private int biggestRank(int key) {
        return rank(key, RankType.BIGGEST, 0, array.length - 1);
    }

    private int rank(int key, RankType rankType, int from, int to) {

        int foundIndex = -1;

        while (from <= to) {
            int mid = from + (to - from) / 2;
            if (key < array[mid]) {
                to = mid - 1;
            } else if (key > array[mid]) {
                from = mid + 1;
            } else if (rankType != RankType.EXACT) {

                int otherIndex = foundIndex = mid;
                while (otherIndex != -1) {
                    if (rankType == RankType.SMALLEST) {
                        otherIndex = rank(key, rankType, from, foundIndex - 1);
                    } else if (rankType == RankType.BIGGEST) {
                        otherIndex = rank(key, rankType, foundIndex + 1, to);
                    }

                    if (otherIndex != -1) {
                        foundIndex = otherIndex;
                    }
                }
                break;
            } else {
                return mid;
            }
        }

        return foundIndex;
    }

    private enum RankType {EXACT, SMALLEST, BIGGEST}
}
