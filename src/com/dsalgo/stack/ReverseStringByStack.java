package com.dsalgo.stack;

import java.util.Stack;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
 */
class ReverseStringByStack {
    public String reverse(String S) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < S.length(); i++) {
            stack.push(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder(S.length());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}