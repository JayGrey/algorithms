package org.example.ex._1._2._6;

public class Runner {

    public static boolean isCircularRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }

        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.substring(i)) && a.substring(i).concat(a.substring(0, i)).equals(b)) {
                return true;
            }
        }
        return false;
    }

}
