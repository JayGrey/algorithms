package org.example.ex._1._2._6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Runner1_2_6Test {
    @Test
    public void test() {

        // check trash data
        assertFalse(Runner.isCircularRotation(null, null));
        assertFalse(Runner.isCircularRotation("null", null));
        assertFalse(Runner.isCircularRotation(null, "null"));

        assertFalse(Runner.isCircularRotation("abc", "def"));
        assertFalse(Runner.isCircularRotation("abc", "bcad"));
        assertFalse(Runner.isCircularRotation("abc", "bcc"));

        assertTrue(Runner.isCircularRotation("abc", "cab"));
        assertTrue(Runner.isCircularRotation("cab", "abc"));
        assertTrue(Runner.isCircularRotation("abc", "bca"));
        assertTrue(Runner.isCircularRotation("a", "a"));
        assertTrue(Runner.isCircularRotation("aa", "aa"));
        assertTrue(Runner.isCircularRotation("ACTGACG", "TGACGAC"));

    }
}