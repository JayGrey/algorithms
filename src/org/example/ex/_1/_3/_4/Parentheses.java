package org.example.ex._1._3._4;

import org.example.ex._1._3._1.FixedCapacityStackOfStrings;

public class Parentheses {
    public static boolean validate(String string) {
        final String OPEN_BRACKET_1 = "(";
        final String OPEN_BRACKET_2 = "[";
        final String OPEN_BRACKET_3 = "{";

        final String CLOSE_BRACKET_1 = ")";
        final String CLOSE_BRACKET_2 = "]";
        final String CLOSE_BRACKET_3 = "}";

        if (string == null) {
            return false;
        }

        final String[] elements = string.split("");
        final FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(elements.length);

        for (final String element : elements) {
            if (OPEN_BRACKET_1.equals(element) || OPEN_BRACKET_2.equals(element) || OPEN_BRACKET_3.equals(element)) {
                stack.push(element);
            } else if (CLOSE_BRACKET_1.equals(element)) {
                if (stack.isEmpty() || !OPEN_BRACKET_1.equals(stack.pop())) {
                    return false;
                }
            } else if (CLOSE_BRACKET_2.equals(element)) {
                if (stack.isEmpty() || !OPEN_BRACKET_2.equals(stack.pop())) {
                    return false;
                }
            } else if (CLOSE_BRACKET_3.equals(element)) {
                if (stack.isEmpty() || !OPEN_BRACKET_3.equals(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
