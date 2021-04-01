package org.example.ex._1._5._20;

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tester {
    private static final String FILE_NAME = "data/tinyUF2.txt";

    public static void main(String[] args) {
        final var uf = new DynamicGrowthWeightedQuickUnionUF();

        try (var reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String[] elements = line.trim().split("\\s+");
                if (elements.length != 2) {
                    continue;
                }

                final var p = Integer.parseInt(elements[0]);
                final var q = Integer.parseInt(elements[1]);

                uf.union(p, q);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        StdOut.println(uf);
    }
}
