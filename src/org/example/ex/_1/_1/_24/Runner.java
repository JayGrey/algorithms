package org.example.ex._1._1._24;

import edu.princeton.cs.algs4.StdOut;

public class Runner {
    public static int gcd(int p, int q) {
        return gcd(p, q, 0);
    }

    public static int gcd(int p, int q, int depth) {
        String indent = repeat("\t", depth);
        StdOut.printf("%sgcd: p:%d q:%d%n", indent, p, q);

        if (q == 0) {
            return p;
        }

        int r = p % q;
        return gcd(q, r, depth + 1);
    }

    public static void main(String[] args) {
        StdOut.println("result gcd: " + gcd(100, 51));
        StdOut.println("result gcd: " + gcd(1111111, 1234567));
    }

    private static String repeat(String val, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(val);
        }

        return result.toString();
    }
}
