package com.dsalgo.stack;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/stack-permutations/1
 */
public class StackPermutation {
    public static int isStackPermutation(int N, int[] A, int[] B) {
        Stack<Integer> stack = new Stack();
        int j = 0;
        for (int i = 0; i < B.length; i++) {
            if (stack.isEmpty() || stack.peek() != B[i]) {
                while (j < A.length && A[j] != B[i]) {
                    stack.push(A[j]);
                    j++;
                }
                if (j == A.length) return 0;
                j++;
            } else {
                if (!stack.isEmpty() && stack.peek() == B[i]) stack.pop();
                else return 0;
            }
        }
        return 1;
    }
}
