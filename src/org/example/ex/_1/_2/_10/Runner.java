package org.example.ex._1._2._10;

import edu.princeton.cs.algs4.StdRandom;

public class Runner {
    public static void main(String[] args) {
        final int TRIES = 100;

        final VisualCounter counter = new VisualCounter(TRIES);

        for (int i = 0; i < TRIES; i++) {
            if (StdRandom.bernoulli(0.55)) {
                counter.increment();
            } else {
                counter.decrement();
            }
        }

        counter.drawCounter();
    }
}
