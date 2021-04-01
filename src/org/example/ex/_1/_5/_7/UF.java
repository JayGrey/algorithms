package org.example.ex._1._5._7;

import java.util.Arrays;

public abstract class UF implements IUF {
    protected final int[] id;
    protected int count;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int[] connections() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + Arrays.toString(id);
    }
}
