package org.example.ex._1._1._20;

public class Runner {
    public static double lnFact(int N) {
        return Math.log(fact(N));
    }

    private static long fact(int N) {
        if (N <= 1) {
            return 1;
        }

        return N * fact(N - 1);
    }

    public static double lnFact2(int N) {
        if (N <= 1) {
            return 0;
        }

        return Math.log(N) + lnFact2(N - 1);
    }

    public static long fact2(int N) {
        return Math.round(Math.exp(lnFact2(N)));
    }

    public static void main(String[] args) {
        /*System.out.println(lnFact(24));
        System.out.println(lnFact2(1000));*/
        System.out.println(fact(20));
        System.out.println(fact2(20));
    }
}
