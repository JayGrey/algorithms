package org.example.ex._1._2._9;

public class Util {
    public static int rank(int key, int[] array, Counter counter) {
        counter.increment();

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
}
