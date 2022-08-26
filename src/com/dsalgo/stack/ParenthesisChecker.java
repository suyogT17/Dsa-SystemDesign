package com.dsalgo.stack;

import java.util.Stack;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
 */
class ParenthesisChecker {
    static boolean ispar(String x) {
        Stack<Character> stack = new Stack();
        for (char c : x.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                if (c == '{') stack.push('}');
                if (c == '(') stack.push(')');
                if (c == '[') stack.push(']');
            } else if (c == '}' || c == ')' || c == ']') {
                if (!stack.isEmpty() && c == stack.peek()) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
