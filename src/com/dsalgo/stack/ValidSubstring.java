package com.dsalgo.stack;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/valid-substring0624/1
 * Given a string S consisting only of opening and closing parenthesis 'ie '('  and ')', find out the length of the longest valid(well-formed) parentheses substring.
 * NOTE: Length of the smallest valid substring ( ) is 2.
 *
 * Example 1:
 *
 * Input: S = "(()("
 * Output: 2
 * Explanation: The longest valid
 * substring is "()". Length = 2.
 */
public class ValidSubstring {
    static int findMaxLen(String S) {
        // code here
        Stack<Integer> stack = new Stack();
        int count = 0;
        int i = 0;
        //stack.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') stack.push(i);
            else if (!stack.isEmpty() && S.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
            i++;
        }
        //System.out.println(stack);
        int ans = Integer.MIN_VALUE;
        int n = S.length();
        if (stack.isEmpty()) return n;
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (count < n - temp - 1) {
                count = n - temp - 1;
            }
            n = temp;
        }
        if (count < n - 0) {
            count = n - 0;
        }
        return count;
    }
}
