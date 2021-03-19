package org.example.ex._1._4._44;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

public class BirthdayProblem {
    private static final int NUMBER_OF_TESTS = 1_000_000;

    public static void main(String[] args) {
        StdOut.print("enter number or values: ");
        final int N = StdIn.readInt();

        final int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = StdRandom.uniform(N);
        }


        final int[] tests = new int[NUMBER_OF_TESTS];
        for (int t = 0; t < NUMBER_OF_TESTS; t++) {
            final Set<Integer> keys = new HashSet<>();

            for (int i = 0; i < N; i++) {
                if (keys.contains(numbers[i])) {
                    tests[t] = i;
                    break;
                } else {
                    keys.add(numbers[i]);
                }
            }
        }

        final int avg = getAverage(tests);
        StdOut.printf("%d | %f%n", avg, Math.sqrt(Math.PI * (N / 2.0)));

    }

    private static int getAverage(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        return sum / array.length;
    }
}
