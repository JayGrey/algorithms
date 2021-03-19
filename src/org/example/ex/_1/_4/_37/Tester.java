package org.example.ex._1._4._37;

import edu.princeton.cs.algs4.StdOut;
import org.example.ex._1._3._1.FixedCapacityStack;
import org.example.ex._1._3._3.FixedCapacityStackOfInts;

public class Tester {
    public static void main(String[] args) {
        StdOut.println("without autoboxing");
        for (int n = 8; n < Integer.MAX_VALUE / 2; n += n) {
            final FixedCapacityStackOfInts stack = new FixedCapacityStackOfInts(n);

            final long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                stack.push(i);
                stack.pop();
            }
            final long endTime = System.currentTimeMillis();

            StdOut.printf("%9d | %9d%n", n, endTime - startTime);
        }
        //
        StdOut.println("with autoboxing");
        for (int n = 8; n < Integer.MAX_VALUE / 2; n += n) {
            final FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(n);

            final long startTime = System.currentTimeMillis();
            for (int i = 0; i < n; i++) {
                stack.push(i);
                final int value = stack.pop();
            }
            final long endTime = System.currentTimeMillis();

            StdOut.printf("%9d | %9d%n", n, endTime - startTime);
        }
    }
}
