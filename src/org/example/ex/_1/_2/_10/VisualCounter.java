package org.example.ex._1._2._10;

import edu.princeton.cs.algs4.StdDraw;
import org.example.ex._1._2._9.Counter;

public final class VisualCounter {
    private final Counter counter;
    private final int max;
    private final int[] counterValue;
    private int currentValue;

    public VisualCounter(int max) {
        counter = new Counter("visualCounter");

        this.max = max;
        this.counterValue = new int[max];
        this.currentValue = 0;
    }

    public void increment() {
        if (currentValue < max) {
            counter.increment();
            counterValue[currentValue++] = counter.tally();
        }
    }

    public void decrement() {
        if (currentValue < max) {
            counter.decrement();
            counterValue[currentValue++] = counter.tally();
        }
    }

    public int tally() {
        return counter.tally();
    }

    public void drawCounter() {
        StdDraw.setXscale(0, max);
        StdDraw.setYscale(-max, max);

        for (int i = 1; i < counterValue.length; i++) {
            StdDraw.line(i-1, counterValue[i-1], i, counterValue[i]);
        }
    }
}
