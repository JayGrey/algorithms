package org.example.ex._1._1._19;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
       /* for (int i = 0; i < 100; i++) {
            final long start = System.currentTimeMillis();
            F(i);
            final long end = System.currentTimeMillis() - start;
            StdOut.printf("%d: %d ms%n",i, end);
        }*/
        final int N = 100;
        /*final long start = System.currentTimeMillis();
        final long value = F(N);
        final long end = System.currentTimeMillis() - start;
        StdOut.printf("%d: %d ms, value = %d%n", N, end, value);*/

        StdOut.println();
        final long start1 = System.currentTimeMillis();
        final long value1 = FCache(N);
        final long end1 = System.currentTimeMillis() - start1;
        StdOut.printf("%d: %d ms, value = %d%n", N, end1, value1);

    }

    static long F(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        return F(N - 1) + F(N - 2);
    }

    static long FCache(final int N) {
        long[] cache = new long[N + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;

        class Fibonacci {
            long calc(final int N) {
                if (cache[N] == -1) {
                    long value = calc(N - 1) + calc(N - 2);
                    cache[N] = value;
                    return value;
                } else {
                    return cache[N];
                }
            }
        }

        return new Fibonacci().calc(N);
    }
}
