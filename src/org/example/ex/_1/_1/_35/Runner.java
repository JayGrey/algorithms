package org.example.ex._1._1._35;

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Runner {
    private static final int SIDES = 6;
    private static final int DICES = 2;

    public static void main(String[] args) {

        final double[] dist = new double[DICES * SIDES + 1];

        for (int i = 1; i <= SIDES; i++) {
            for (int j = 1; j <= SIDES; j++) {
                dist[i + j] += 1.0;
            }
        }

        for (int k = 2; k <= 2 * SIDES; k++) {
            dist[k] /= 36.0;
        }

//        System.out.println(Arrays.toString(dist));
        StdOut.println("distribution: " + arrayToString(dist));
        StdOut.println("experiment:   " + arrayToString(experiment(10_000_000)));
    }

    private static double[] experiment(final int TRIES) {
        int[] array = new int[DICES * SIDES + 1];
        final Random random = new Random();

        for (int i = 0; i < TRIES; i++) {
            int sum = 0;
            for (int j = 0; j < DICES; j++) {
                sum += random.nextInt(SIDES) + 1;
            }
            array[sum] +=1;
        }

        final double[] result = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i] / (1.0 * TRIES);
        }

        return result;
    }

    private static String arrayToString(double[] array) {
        return DoubleStream.of(array)
                .mapToObj(_d -> String.format("%.03f", _d))
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
