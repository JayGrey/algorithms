package org.example.ex._1._1._18;

import edu.princeton.cs.algs4.StdOut;

public class Runner {
    public static void main(String[] args) {

        StdOut.println(multiply(2, 3));

        StdOut.println();

        StdOut.println(mystery(2, 25) == multiply(2, 25));
        StdOut.println(mystery(3, 11) == multiply(3, 11));
        StdOut.println(mystery(11, 3) == multiply(11, 3));

        StdOut.println();

        StdOut.println(mystery1(2, 3) == pow(2, 3));
        StdOut.println(mystery1(3, 2) == pow(3, 2));
        StdOut.println(mystery1(2, 10) == pow(2, 10));
    }

    static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }

        if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        }

        return mystery(a + a, b / 2) + a;
    }

    static int mystery1(int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b % 2 == 0) {
            return mystery1(a * a, b / 2);
        }

        return mystery1(a * a, b / 2) * a;
    }

    static int multiply (int a, int b) {
        if (b == 0) {
            return 0;
        }

        if (b == 1) {
            return a;
        }

        return a + multiply(a, b - 1);
    }

    static int pow (int a, int b) {
        if (b == 0) {
            return 1;
        }

        if (b == 1) {
            return a;
        }

        return a * pow(a, b - 1);
    }
}
