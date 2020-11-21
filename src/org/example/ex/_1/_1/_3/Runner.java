package org.example.ex._1._1._3;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner {
    public static void main(String... args) {
        if (args.length < 2) {
            System.err.println("too few arguments");
        }

        System.out.println(exercise1_1_3(Stream.of(args).mapToInt(Integer::valueOf).toArray()) ? "equal" : "not equal");

    }

    static boolean exercise1_1_3(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        final int n = numbers[0];

        return IntStream.of(numbers).allMatch(i -> i == n);
    }
}
