package org.example.ex._1._4._43;

import edu.princeton.cs.algs4.StdOut;
import org.example.ex._1._3._7.IStack;
import org.example.ex._1._3._7.Stack;

public class Tester {

    private static final int MAX_VALUE = 67_108_864;

    public static void main(String[] args) {
        // check stack with resizing array
        StdOut.println("resizing array");
        long previousTime = 1;
        for (int n = 8; n < MAX_VALUE; n += n) {
            previousTime = test(new StackWithResizingArray<>(), n, previousTime);
        }

        // check stack with linked list
        StdOut.println();
        StdOut.println("linked list");
        previousTime = 1;
        for (int n = 8; n < MAX_VALUE; n += n) {
            previousTime = test(new Stack<>(), n, previousTime);
        }

    }

    private static long test(IStack<Integer> stack, int N, long previousTime) {

        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < N / 2; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N / 2; i++) {
            stack.pop();
        }
        final long endTime = System.currentTimeMillis();

        StdOut.printf("%9d | %9d | %d%n", N, endTime - startTime, (endTime - startTime) / previousTime);
        return Math.max(endTime - startTime, 1);
    }
}
