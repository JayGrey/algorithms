package org.example.ex._1._4._10;

public class Search {

    public static int smallestRank(int[] array, int key) {
        return smallestRank(array, 0, array.length - 1, key);
    }

    public static int smallestRank(int[] array, int from, int to, int key) {
        if (array == null || from < 0 || to >= array.length || from > to) {
            return -1;
        }

        int foundIndex = -1;

        while (from <= to) {
            final int middle = (from + to) / 2;

            if (array[middle] == key) {
                int otherIndex = foundIndex = middle;

                while (otherIndex != -1) {
                    otherIndex = smallestRank(array, from, foundIndex - 1, key);
                    if (otherIndex != -1) {
                        foundIndex = otherIndex;
                    }
                }

                break;
            } else if (array[middle] < key) {
                from = middle + 1;
            } else {
                to = middle - 1;
            }
        }

        return foundIndex;
    }
}
