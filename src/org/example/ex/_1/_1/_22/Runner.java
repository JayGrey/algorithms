package org.example.ex._1._1._22;

public class Runner {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    // Index of key in a[], if present, is not smaller than lo
    // and not larger than hi.
    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        String ident = repeat("\t", depth);

        System.out.format("%srank: lo:%d hi:%d%n", ident, lo, hi);

        if (lo > hi) {
            System.out.format("%snot found%n", ident);
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (key < a[mid]) {
            return rank(key, a, lo, mid - 1, depth + 1);
        } else if (key > a[mid]) {
            return rank(key, a, mid + 1, hi, depth + 1);
        } else {
            System.out.format("%sfound: %d%n", ident, mid);
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 16, 20, 35, 78};

        rank(36, a);

//        rank(6, a);
    }

    private static String repeat(String val, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(val);
        }

        return result.toString();
    }
}
