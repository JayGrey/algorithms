package org.example.ex._1._1._5;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        if (args == null) {
            return;
        }

        System.out.println(exercise115(Stream.of(args).mapToDouble(Double::valueOf).toArray()));
    }

    static boolean exercise115(double[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        return DoubleStream.of(nums).allMatch(d -> d > 0.0 && d < 1.0);
    }
}
