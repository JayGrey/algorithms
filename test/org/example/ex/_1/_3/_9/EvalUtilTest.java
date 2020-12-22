package org.example.ex._1._3._9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvalUtilTest {

    @Test
    public void completeBracketsNullTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            EvalUtil.completeBrackets(null);
        });
    }

    @Test
    public void completeBracketsTest() {
        assertEquals("((1+2)*((3-4)*(5-6)))", EvalUtil.completeBrackets("1 + 2 ) * 3 - 4 ) * 5 - 6 )))"));
        assertEquals("((12+21)*((34-43)*(56-65)))", EvalUtil.completeBrackets("12 + 21 ) * 34 - 43 ) * 56 - 65 )))"));
    }

    @Test
    public void infixToPostfixExpressionTest() {
        assertEquals("1 2 +", EvalUtil.infixToPostfixExpression("(1 + 2)"));
        assertEquals("1 2 + 3 *", EvalUtil.infixToPostfixExpression("((1 + 2) * 3)"));
        assertEquals("3 1 2 + *", EvalUtil.infixToPostfixExpression("(3 * (1 + 2))"));
    }

    @Test
    public void evaluatePostfixExpressionTest() {
        assertEquals(3, EvalUtil.evaluatePostfixExpression("1 2 +"));
        assertEquals(9, EvalUtil.evaluatePostfixExpression("1 2 + 3 *"));
        assertEquals(9, EvalUtil.evaluatePostfixExpression("3 1 2 + *"));
    }
}