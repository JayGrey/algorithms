package org.example.ex._1._5._20;

import org.example.ex._1._3._33.ResizingArray;
import org.example.ex._1._5._7.IUF;

public class DynamicGrowthWeightedQuickUnionUF implements IUF {
    private final ResizingArray<Integer> sites = new ResizingArray<>();
    private final ResizingArray<Integer> id = new ResizingArray<>();
    private final ResizingArray<Integer> sz = new ResizingArray<>();
    private int count;

    @Override
    public int count() {
        return count;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int find(int p) {
        int pId = getSite(p);
        while (pId != id.get(pId)) {
            pId = id.get(pId);
        }

        return pId;
    }

    @Override
    public void union(int p, int q) {
        final int rootP = find(p);
        final int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (sz.get(rootP) < sz.get(rootQ)) {
            id.set(rootP, rootQ);
            sz.set(rootQ, sz.get(rootQ) + sz.get(rootP));
        } else {
            id.set(rootQ, rootP);
            sz.set(rootP, sz.get(rootP) + sz.get(rootQ));
        }

        count--;
    }

    private int getSite(int site) {
        for (int i = 0; i < sites.size(); i++) {
            final Integer element = sites.get(i);
            if (element != null && element == site) {
                return i;
            }
        }

        sites.addLast(site);
        id.addLast(sites.size() - 1);
        sz.addLast(1);
        count++;

        return sites.size() - 1;
    }

    @Override
    public String toString() {
        return String.format("id:    %s%nsites: %s", id, sites);
    }
}
