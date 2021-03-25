package org.example.ex._1._5._14;

import org.example.ex._1._5._7.QuickUnionUF;

public class WeightedQuickUnionByHeightUF extends QuickUnionUF {
    private final int[] height;

    public WeightedQuickUnionByHeightUF(int N) {
        super(N);
        height = new int[N];
        for (int i = 0; i < N; i++) {
            height[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        final int pRoot = find(p);
        final int qRoot = find(q);

        final int pHeight = height[pRoot];
        final int qHeight = height[qRoot];

        if (pRoot == qRoot) {
            return;
        }

        if (pHeight == qHeight) {
            id[pRoot] = qRoot;
            height[qRoot]++;
        } else if (pHeight > qHeight) {
            id[qRoot] = pRoot;
        } else {
            id[pRoot] = qRoot;
        }

        count--;
    }
}
