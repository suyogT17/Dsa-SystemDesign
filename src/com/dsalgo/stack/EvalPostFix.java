package com.dsalgo.stack;

import java.util.Stack;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
 */
class EvalPostFix {
    public static int evaluatePostFix(String S) {
        // Your code here
        Stack<Integer> stack = new Stack();
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int second = stack.pop();
                int first = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(first / second);
                        break;
                }
            }
        }
        return stack.peek();
    }
}