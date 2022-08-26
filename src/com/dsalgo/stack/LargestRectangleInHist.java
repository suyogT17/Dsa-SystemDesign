package com.dsalgo.stack;

import java.util.Stack;

/**
 * Problem Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
class LargestRectangleInHist {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int[] nsr = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) nsr[i] = heights.length;
            else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                if (stack.isEmpty()) nsr[i] = heights.length;
                else nsr[i] = stack.peek();
            }
            stack.push(i);
        }
        //System.out.println(Arrays.toString(nsr));
        stack = new Stack();
        int[] nsl = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) nsl[i] = -1;
            else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                if (stack.isEmpty()) nsl[i] = -1;
                else nsl[i] = stack.peek();
            }
            stack.push(i);
        }
        //System.out.println(Arrays.toString(nsl));
        //int[] width = new int[heights.length];
        int output = 0;
        for (int i = 0; i < heights.length; i++) {
            output = Math.max((nsr[i] - nsl[i] - 1) * heights[i], output);
        }
        return output;
    }
}