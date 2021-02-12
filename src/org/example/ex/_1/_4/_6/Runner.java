package org.example.ex._1._4._6;

import edu.princeton.cs.algs4.StdOut;
import org.example.ex._1._3._33.ResizingArray;

import java.util.function.Function;

public class Runner {


    public static void main(String[] args) {
        final long INIT_VALUE = 10L;
        final long END_VALUE = 50_000L;

        printResults(
                test(Runner::a, INIT_VALUE, END_VALUE),
                test(Runner::b, INIT_VALUE, END_VALUE),
                test(Runner::c, INIT_VALUE, END_VALUE));
    }

    private static void printResults(ResizingArray<Data> dataA, ResizingArray<Data> dataB, ResizingArray<Data> dataC) {
        final int rows = dataA.size();

        StdOut.println("-----------------------------------------------------------------------------");
        StdOut.println("||      method A        ||         method B        ||         method C     ||");
        StdOut.println("-----------------------------------------------------------------------------");

        for (int i = 0; i < rows; i++) {
            final Data dataARow = dataA.get(i);
            final Data dataBRow = dataB.get(i);
            final Data dataCRow = dataC.get(i);

            if (dataARow == null || dataBRow == null || dataCRow == null) {
                continue;
            }
            StdOut.printf("%6d | %6d | %5.2f || %6d | %6d | %5.2f || %6d | %6d | %5.2f%n",
                    dataARow.a, dataARow.b, (dataARow.b * 1.0 / dataARow.a),
                    dataBRow.a, dataBRow.b, (dataBRow.b * 1.0 / dataBRow.a),
                    dataCRow.a, dataCRow.b, (dataCRow.b * 1.0 / dataCRow.a));
        }
    }

    private static long a(long N) {
        int sum = 0;

        for (long n = N; n > 0; n /= 2) {
            for (long i = 0; i < n; i++) {
                sum++;
            }
        }
        return sum;
    }

    private static long b(long N) {
        int sum = 0;

        for (int i = 1; i < N; i *= 2) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }

    private static long c(long N) {
        int sum = 0;

        for (int i = 1; i < N; i *= 2) {
            for (int j = 0; j < N; j++) {
                sum++;
            }
        }
        return sum;
    }

    private static ResizingArray<Data> test(Function<Long, Long> function, long initValue, long endValue) {
        final ResizingArray<Data> result = new ResizingArray<>();

        for (long i = initValue; i < endValue; i += i) {
            result.addLast(new Data(i, function.apply(i)));
        }

        return result;
    }

    private static final class Data {
        private final long a;
        private final long b;

        public Data(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }
}
