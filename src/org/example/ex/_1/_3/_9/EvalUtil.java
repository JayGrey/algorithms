package org.example.ex._1._3._9;

import org.example.ex._1._3._7.Stack;

import java.util.Iterator;

public class EvalUtil {

    public static String completeBrackets(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        Stack<String> expression = new Stack<>();
        Stack<String> operations = new Stack<>();
        for (Token token : getTokenIterable(input)) {
            switch (token.type) {
                case NUMBER: {
                    expression.push(token.value);
                    break;
                }

                case OPERATION: {
                    operations.push(token.value);
                    break;
                }

                case CLOSE_BRACKET: {
                    String exp2 = expression.pop();
                    String exp1 = expression.pop();
                    String op = operations.pop();
                    expression.push(String.format("(%s%s%s)", exp1, op, exp2));
                    break;
                }
            }
        }

        return expression.pop();
    }

    private static Iterable<Token> getTokenIterable(String input) {
        return () -> new TokenIterator(input);
    }


    private enum TokenType {CLOSE_BRACKET, NUMBER, OPERATION}

    private static class TokenIterator implements Iterator<Token> {
        private final Queue<Token> tokens;

        public TokenIterator(String input) {
            tokens = parseString(input);
        }

        private Queue<Token> parseString(String input) {
            final Queue<Token> result = new Queue<>();
            final Queue<String> digitBuffer = new Queue<>();

            for (int i = 0; i < input.length(); i++) {
                final char ch = input.charAt(i);
                if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
                    if (!digitBuffer.isEmpty()) {
                        result.enqueue(new Token(convertToString(digitBuffer), TokenType.NUMBER));
                        digitBuffer.clear();
                    }
                    result.enqueue(new Token(String.valueOf(ch), TokenType.OPERATION));
                } else if (ch == ')') {
                    if (!digitBuffer.isEmpty()) {
                        result.enqueue(new Token(convertToString(digitBuffer), TokenType.NUMBER));
                        digitBuffer.clear();
                    }
                    result.enqueue(new Token("", TokenType.CLOSE_BRACKET));
                } else if (Character.isDigit(ch)) {
                    digitBuffer.enqueue(String.valueOf(ch));
                }
            }

            return result;
        }

        private String convertToString(Queue<String> queue) {
            final StringBuilder stringBuilder = new StringBuilder();

            while (!queue.isEmpty()) {
                stringBuilder.append(queue.dequeue());
            }

            return stringBuilder.toString();
        }

        @Override
        public boolean hasNext() {
            return !tokens.isEmpty();
        }

        @Override
        public Token next() {
            return tokens.dequeue();
        }
    }

    private static class Token {
        private final String value;
        private final TokenType type;

        public Token(String value, TokenType type) {
            this.value = value;
            this.type = type;
        }
    }
}
