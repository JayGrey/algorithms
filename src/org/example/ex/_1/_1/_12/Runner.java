package org.example.ex._1._1._12;

import edu.princeton.cs.algs4.StdOut;

public class Runner {
    public static void main(String[] args) {
        int[] a = new int[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = 9 - i;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = a[a[i]];
        }

        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}
