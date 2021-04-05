package org.example.ex._1._5._17;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._5._7.UF;
import org.example.ex._1._5._7.WeightedQuickUnionUF;

public class ErdosRenyi {
    public static void main(String[] args) {
        StdOut.print("N: ");
        final int N = StdIn.readInt();

        final int connections = count(N);
        StdOut.printf("connections: %d%n", connections);

    }

    public static int count(int N) {
        return count(N, new WeightedQuickUnionUF(N));
    }

    public static int count(int N, UF uf) {
        int connections = 0;

        while (uf.count() > 1) {
            final int p = StdRandom.uniform(N);
            final int q = StdRandom.uniform(N);

            if (!uf.connected(p, q)) {
                uf.union(p, q);
            }
            connections++;
        }

        return connections;
    }
}
