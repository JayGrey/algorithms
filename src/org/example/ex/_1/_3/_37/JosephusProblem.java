package org.example.ex._1._3._37;

public final class JosephusProblem {


    public int[] getSolution(final int N, final int M) {
        if (M < 1 || N < 1) {
            return new int[0];
        }

        final LinkedRing linkedRing = new LinkedRing(N);

        final int[] result = new int[N];
        int currentIndex = 0;
        while (linkedRing.size() > 0) {
            linkedRing.shift(M - 1);
            result[currentIndex++] = linkedRing.remove();
        }

        return result;
    }


}
