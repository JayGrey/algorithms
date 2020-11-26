package org.example.ex._1._2._9;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        final Counter counter = new Counter("counter");

        final int[] whitelist = new In(args[0]).readAllInts();

        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            final int key = StdIn.readInt();
            if (Util.rank(key, whitelist, counter) < 0) {
                StdOut.println(key);
            }
        }

        StdOut.println("keys examined: " + counter.tally());
    }
}
