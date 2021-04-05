package org.example.ex._1._5._21;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.example.ex._1._5._17.ErdosRenyi;

public class ErdosRenyiModel {
    public static void main(String[] args) {
        StdOut.print("N: ");
        final int N = StdIn.readInt();

        StdOut.print("tests: ");
        final int tests = StdIn.readInt();

        final int[] connectionsArray = new int[tests];

        for (int i = 0; i < tests; i++) {
            connectionsArray[i] = ErdosRenyi.count(N);
        }

        StdOut.printf("N: %d, tests: %d, expected: %f, actual: %f%n", N, tests,
                calcExpected(N), calcActual(connectionsArray));
    }

    private static double calcActual(int[] array) {
        double sum = 0;
        for (int e : array) {
            sum += e;
        }

        return sum / array.length;
    }

    private static double calcExpected(int N) {
        return (N * Math.log(N)) / 2.0;
    }
}
