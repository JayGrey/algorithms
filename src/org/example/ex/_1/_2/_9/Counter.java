package org.example.ex._1._2._9;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

public final class Counter {
    private final String name;
    private final AtomicInteger counter = new AtomicInteger(0);

    public Counter(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    public void increment() {
        counter.incrementAndGet();
    }

    public void decrement() {
        counter.decrementAndGet();
    }

    public int tally() {
        return counter.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Counter counter1 = (Counter) o;
        return name.equals(counter1.name) &&
                counter.equals(counter1.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, counter);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Counter.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("counter=" + counter)
                .toString();
    }
}
