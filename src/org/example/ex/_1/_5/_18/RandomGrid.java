package org.example.ex._1._5._18;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._3._34.RandomBag;

public class RandomGrid {
    private static Connection[] generate(int N) {
        final RandomBag<Connection> connections = new RandomBag<>();

        for (int p = 0; p < N; p++) {
            for (int q = p + 1; q < N; q++) {
                if (StdRandom.bernoulli()) {
                    connections.add(new Connection(p, q));
                } else {
                    connections.add(new Connection(q, p));
                }
            }
        }

        Connection[] result = new Connection[connections.size()];
        int i = 0;
        for (Connection connection : connections) {
            result[i++] = connection;
        }

        return result;
    }

    public static void main(String[] args) {
        StdOut.print("N: ");
        final int N = StdIn.readInt();

        final Connection[] connections = generate(N);

        for (Connection connection : connections) {
            StdOut.println(connection);
        }
    }
}
