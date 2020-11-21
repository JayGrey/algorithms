package org.example.ex._1._1._23;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Runner {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            final int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int[] whiteList = new In(args[0]).readAllInts();
        final boolean printInWhitelist = "+".equals(args[1]);

        Arrays.sort(whiteList);

        while (!StdIn.isEmpty()) {
            final int key = StdIn.readInt();
            final boolean isInWhitelist = rank(key, whiteList) >= 0;
            if (isInWhitelist && !printInWhitelist
                    || !isInWhitelist && printInWhitelist) {
                StdOut.println(key);
            }
        }
    }
}
