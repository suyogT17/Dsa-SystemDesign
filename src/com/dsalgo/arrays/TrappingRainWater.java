package com.dsalgo.arrays;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/trapping-rain-water/
 */
class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int right[] = new int[n];
        int left[] = new int[n];
        right[0] = height[0];
        for (int i = 1; i < n; i++) {
            right[i] = Math.max(height[i], right[i - 1]);
        }
        System.out.println(Arrays.toString(right));
        left[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            left[i] = Math.max(height[i], left[i + 1]);
        }
        int output = 0;
        for (int i = 0; i < n; i++) {
            output += Math.abs(Math.min(right[i], left[i]) - height[i]);
        }
        return output;
    }
}