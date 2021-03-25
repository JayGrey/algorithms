package org.example.ex._1._5._18;

public class Connection {
    public final int p;
    public final int q;

    public Connection(int p, int q) {
        this.p = p;
        this.q = q;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", p, q);
    }
}
