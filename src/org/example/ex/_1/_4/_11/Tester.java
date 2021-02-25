package org.example.ex._1._4._11;

import edu.princeton.cs.algs4.StdOut;
import org.example.ex._1._4._10.Search;

public class Tester {
    private static final int MAX_LENGTH = 10_000_000;


    public static void main(String[] args) {
        for (int i = 8; i < MAX_LENGTH; i += i) {

            final int[] array = new int[i];

            final long startTime = System.currentTimeMillis();

            final StaticSETofInts set = new StaticSETofInts(array);
            assert set.howMany(0) == i;

            StdOut.printf("%8d | %3d%n", i, System.currentTimeMillis() - startTime);
        }
    }
}

