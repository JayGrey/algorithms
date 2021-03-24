package org.example.ex._1._5._13;

import org.example.ex._1._5._7.WeightedQuickUnionUF;

public class WeightedQuickUnionWithPathCompressionUF extends WeightedQuickUnionUF {
    public WeightedQuickUnionWithPathCompressionUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        final int rootP = find(p);
        final int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (sz[rootP] < sz[rootQ]) {
            id[rootP] = rootQ;
            compressPath(p, rootQ);
            sz[rootQ] += sz[rootP];
        } else {
            id[rootQ] = rootP;
            compressPath(q, rootP);
            sz[rootP] += sz[rootQ];
        }

        count--;
    }

    private void compressPath(int site, int root) {
        while (id[site] != site) {
            final int siteRoot = id[site];
            id[site] = root;
            site = siteRoot;
        }

        id[site] = root;
    }
}
