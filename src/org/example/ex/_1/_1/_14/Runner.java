package org.example.ex._1._1._14;

public class Runner {
    public static int lg(int N) {
        if (N <= 0) {
            return 1;
        }

        int num = 1;
        int result = 0;

        while (true) {
            num *= 2;

            if (num > N) {
                break;
            }

            result += 1;
        }

        return result;
    }

    public static int lg_2(int N) {
        if (N <= 0) {
            return 1;
        }

        int result = -1;

        while (N > 0) {
            N >>= 1;
            result += 1;
        }

        return result;
    }
}
