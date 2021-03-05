package org.example.ex._1._4._3;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.example.ex._1._3._33.ResizingArray;
import org.example.ex._1._4._2.ThreeSum;

import java.awt.*;

public class DoublingTest {
    public static void main(String[] args) {
        final ResizingArray<Data> array = getData(10, 8_000);

        printTable(array);
        drawStandardPlot(array);
        drawLogLogPlot(array);
    }

    private static void printTable(ResizingArray<Data> array) {
        StdOut.printf("|   N   |    T   | log2N  | log2T |%n");
        StdOut.printf("-----------------------------------%n");

        final double ln2 = Math.log(2.0);
        for (Data data : array) {
            final double logN = Math.max(Math.log(data.N), 0.0) / ln2;
            final double logT = Math.max(Math.log(data.T), 0.0) / ln2;
            StdOut.printf("%8d|%8d|%8.3f|%8.3f%n", data.N, data.T, logN, logT);
        }
    }

    private static void drawLogLogPlot(ResizingArray<Data> array) {
        if (array == null || array.isEmpty()) {
            return;
        }

        final Data minData = array.get(0);
        final Data maxData = array.get(array.size() - 1);

        if (minData == null || maxData == null) {
            return;
        }

        StdDraw.setXscale(Math.max(Math.log(minData.N), 0.0), Math.max(Math.log(maxData.N), 0.0));
        StdDraw.setYscale(Math.max(Math.log(minData.T), 0.0), Math.max(Math.log(maxData.T), 0.0));
        StdDraw.setPenColor(Color.BLUE);

        final double ln2 = Math.log(2.0);

        for (int i = 1; i < array.size(); i++) {
            final Data currentPoint = array.get(i);
            final Data previousPoint = array.get(i - 1);

            if (currentPoint == null || previousPoint == null) {
                continue;
            }

            final double previousLogN = Math.max(Math.log(previousPoint.N), 0.0) / ln2;
            final double previousLogT = Math.max(Math.log(previousPoint.T), 0.0) / ln2;

            final double currentLogN = Math.max(Math.log(currentPoint.N), 0.0) / ln2;
            final double currentLogT = Math.max(Math.log(currentPoint.T), 0.0) / ln2;

            StdDraw.line(previousLogN, previousLogT, currentLogN, currentLogT);
        }
    }

    private static void drawStandardPlot(ResizingArray<Data> array) {
        if (array.isEmpty()) {
            return;
        }

        final Data minData = array.get(0);
        final Data maxData = array.get(array.size() - 1);

        if (minData == null || maxData == null) {
            return;
        }

        StdDraw.setXscale(minData.N, maxData.N);
        StdDraw.setYscale(minData.T, maxData.T);
        StdDraw.setPenColor(Color.RED);

        for (int i = 1; i < array.size(); i++) {
            final Data currentPoint = array.get(i);
            final Data previousPoint = array.get(i - 1);

            if (currentPoint == null || previousPoint == null) {
                continue;
            }

            StdDraw.line(previousPoint.N, previousPoint.T, currentPoint.N, currentPoint.T);
        }
    }

    private static long timeTrial(int N) {
        final int MAX = 1_000_000;

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, +MAX);
        }

        final long start = System.currentTimeMillis();
        final int count = ThreeSum.count(a);

        return System.currentTimeMillis() - start;
    }

    private static ResizingArray<Data> getData(int initialValue, int maxValue) {

        final ResizingArray<Data> result = new ResizingArray<>();

        for (int N = initialValue; N < maxValue; N += N) {
            result.addLast(new Data(N, timeTrial(N)));
        }

        return result;
    }

    private static class Data {
        private final long N;
        private final long T;

        public Data(long n, long t) {
            N = n;
            T = t;
        }
    }
}
