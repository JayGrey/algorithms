package org.example.ex._1._1._7;

import edu.princeton.cs.algs4.StdOut;

public class Runner {
    public static void main(String[] args) {
        double t = 9.0;

        while (Math.abs(t - 9.0/t) > 0.001) {
            t = (9.0/t + t) / 2.0;
        }

        StdOut.printf("%.5f\n", t);

        //
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);
    }
}
