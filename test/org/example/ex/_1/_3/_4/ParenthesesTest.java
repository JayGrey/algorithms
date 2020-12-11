package org.example.ex._1._3._4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParenthesesTest {

    @Test
    void validate() {

        assertFalse(Parentheses.validate(null));

        assertTrue(Parentheses.validate(""));
        assertTrue(Parentheses.validate("[()]{}{[()()]()}"));
        assertFalse(Parentheses.validate("[(])"));
        assertFalse(Parentheses.validate("([]"));
        assertFalse(Parentheses.validate("[]("));

    }
}