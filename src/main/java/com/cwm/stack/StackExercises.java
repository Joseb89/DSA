package com.cwm.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackExercises {

    private final List<Character> leftBrackets = Arrays.asList('(', '{', '[', '<');

    private final List<Character> rightBrackets = Arrays.asList(')', '}', ']', '>');

    public String reverseString(String str) {
        if (str == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) stack.push(c);

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty())
            stringBuilder.append(stack.pop());

        return stringBuilder.toString();
    }

    public boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.isEmpty()) return false;

                Character left = stack.pop();

                if (!bracketsMatch(left, ch)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
