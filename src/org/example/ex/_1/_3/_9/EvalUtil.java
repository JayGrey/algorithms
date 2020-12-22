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
        for (Token token : getTokenIterableFromInfixExpression(input)) {
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

    public static String infixToPostfixExpression(String input) {

        final Stack<Token> operations = new Stack<>();
        final Stack<String> expressions = new Stack<>();
        for (Token token : getTokenIterableFromInfixExpression(input)) {
            if (token.type == TokenType.OPERATION) {
                operations.push(token);
            } else if (token.type == TokenType.NUMBER) {
                expressions.push(token.value);
            } else if (token.type == TokenType.CLOSE_BRACKET) {
                final String exp2 = expressions.pop();
                final String exp1 = expressions.pop();
                final String op = operations.pop().value;

                expressions.push(String.format("%s %s %s", exp1, exp2, op));
            }
        }
        return expressions.pop();
    }

    public static long evaluatePostfixExpression(String expression) {
        Stack<Long> result = new Stack<>();

        for (Token token : getTokenIterableFromPostfixExpression(expression)) {
            if (token.type == TokenType.NUMBER) {
                result.push(Long.valueOf(token.value));
            } else if (token.type == TokenType.OPERATION) {
                Long op2 = result.pop();
                Long op1 = result.pop();

                switch (token.value) {
                    case "+": {
                        result.push(op1 + op2);
                        break;
                    }

                    case "-": {
                        result.push(op1 - op2);
                        break;
                    }

                    case "*": {
                        result.push(op1 * op2);
                        break;
                    }

                    case "/": {
                        result.push(op1 / op2);
                        break;
                    }
                }
            }
        }

        return result.pop();
    }

    private static Iterable<Token> getTokenIterableFromInfixExpression(String input) {
        return () -> new InfixTokenIterator(input);
    }

    private static Iterable<Token> getTokenIterableFromPostfixExpression(String input) {
        return () -> new PostfixTokenIterator(input);
    }


    private enum TokenType {OPEN_BRACKET, CLOSE_BRACKET, NUMBER, OPERATION}

    private static class InfixTokenIterator implements Iterator<Token> {
        private final Queue<Token> tokens;

        public InfixTokenIterator(String input) {
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
                } else if (ch == '(') {
                    if (!digitBuffer.isEmpty()) {
                        result.enqueue(new Token(convertToString(digitBuffer), TokenType.NUMBER));
                        digitBuffer.clear();
                    }
                    result.enqueue(Token.OPEN_BRACKET_TOKEN);
                } else if (ch == ')') {
                    if (!digitBuffer.isEmpty()) {
                        result.enqueue(new Token(convertToString(digitBuffer), TokenType.NUMBER));
                        digitBuffer.clear();
                    }
                    result.enqueue(Token.CLOSE_BRACKET_TOKEN);
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

    private static class PostfixTokenIterator implements Iterator<Token> {
        private final Queue<Token> tokens;

        public PostfixTokenIterator(String input) {
            tokens = parseString(input);
        }

        private Queue<Token> parseString(String input) {
            final Queue<Token> result = new Queue<>();
            final Queue<Character> digits = new Queue<>();

            for (int i = 0; i < input.length(); i++) {
                final char ch = input.charAt(i);
                if (Character.isDigit(ch)) {
                    digits.enqueue(ch);
                } else {
                    if (!digits.isEmpty()) {
                        result.enqueue(new Token(convertToString(digits), TokenType.NUMBER));
                        digits.clear();
                    }

                    if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                        result.enqueue(new Token(String.valueOf(ch), TokenType.OPERATION));
                    }
                }
            }
            return result;
        }

        private String convertToString(Queue<Character> digits) {
            final StringBuilder result = new StringBuilder();

            while (!digits.isEmpty()) {
                result.append(digits.dequeue());
            }

            return result.toString();
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
        private static final Token OPEN_BRACKET_TOKEN = new Token("", TokenType.OPEN_BRACKET);
        private static final Token CLOSE_BRACKET_TOKEN = new Token("", TokenType.CLOSE_BRACKET);
        private final String value;
        private final TokenType type;

        public Token(String value, TokenType type) {
            this.value = value;
            this.type = type;
        }
    }
}
