package com.dsalgo.arrays.matrix;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/maximal-rectangle/
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] input = new int[matrix[0].length];
        int output = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0) {
                    input[j] = Character.getNumericValue(matrix[i][j]);
                } else {
                    if (matrix[i][j] == '0') input[j] = 0;
                    else input[j] += 1;
                }
            }
            output = Math.max(output, maxAreaHistogram(input));
        }
        return output;
    }

    //This is also a problem: https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1
    private int maxAreaHistogram(int[] hist) {
        int[] nsl = findNSL(hist);
        int[] nsr = findNSR(hist);
        int[] width = new int[nsl.length];
        for (int i = 0; i < width.length; i++) {
            width[i] = nsr[i] - nsl[i] - 1;
        }
        int maxArea = 0;
        for (int i = 0; i < width.length; i++) {
            maxArea = Math.max(maxArea, width[i] * hist[i]);
        }
        return maxArea;
    }

    private int[] findNSL(int[] hist) {
        Stack<Integer> stack = new Stack();
        int[] output = new int[hist.length];
        for (int i = 0; i < hist.length; i++) {
            if (stack.isEmpty()) output[i] = -1;
            else {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();
                output[i] = (stack.isEmpty()) ? -1 : stack.peek();
            }
            stack.push(i);
        }
        return output;
    }

    private int[] findNSR(int[] hist) {
        Stack<Integer> stack = new Stack();
        int[] output = new int[hist.length];
        for (int i = hist.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) output[i] = hist.length;
            else {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i]) stack.pop();
                output[i] = (stack.isEmpty()) ? hist.length : stack.peek();
            }
            stack.push(i);
        }
        return output;
    }
}