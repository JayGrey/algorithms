package org.example.ex._1._3._16;

import edu.princeton.cs.algs4.In;
import org.example.ex._1._2._11.Date;
import org.example.ex._1._2._11.SmartDate;
import org.example.ex._1._2._13.Transaction;
import org.example.ex._1._3._9.Queue;

import java.util.function.Function;

public class Util {
    public static int[] readInts(String filename) {

        final Integer[] integers = readArrayFromFile(filename, Integer::parseInt);

        final int[] result = new int[integers.length];

        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i];
        }

        return result;
    }

    public static Date[] readDates(String filename) {
        return readArrayFromFile(filename, SmartDate::of);
    }

    public static Transaction[] readTransactions(String filename) {
        return readArrayFromFile(filename, Transaction::of);
    }

    private static <T> T[] readArrayFromFile(String filename, Function<String, T> transform) {
        final In in = new In(filename);

        final Queue<T> q = new Queue<>();

        while (!q.isEmpty()) {
            q.enqueue(transform.apply(in.readString()));
        }

        @SuppressWarnings("unchecked") final T[] result = (T[]) new Object[q.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = q.dequeue();
        }

        return result;
    }
}
