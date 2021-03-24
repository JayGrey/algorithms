package org.example.ex._1._5._7;

public class WeightedQuickUnionUF extends QuickUnionUF {
    protected final int[] sz;

    public WeightedQuickUnionUF(int N) {
        super(N);

        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }


    @Override
    public void union(int p, int q) {
        final int rootP = find(p);
        final int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (sz[rootP] < sz[rootQ]) { // p > q
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }

        count--;
    }
}
