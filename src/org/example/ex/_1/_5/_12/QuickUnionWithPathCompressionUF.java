package org.example.ex._1._5._12;

import org.example.ex._1._5._7.QuickUnionUF;

public class QuickUnionWithPathCompressionUF extends QuickUnionUF {
    public QuickUnionWithPathCompressionUF(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        final int pRoot = find(p);
        final int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        compressPath(p, qRoot);
        compressPath(q, qRoot);

        id[pRoot] = qRoot;
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
