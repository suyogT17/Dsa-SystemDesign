package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 */
class MinSwapKTogether {
    public static int minSwap(int arr[], int n, int k) {
        int ans = Integer.MAX_VALUE;
        int min = 0;
        int count = 0;
        for (int num : arr) {
            if (num <= k) count++;
        }
        for (int x = 0; x < count; x++) {
            if (arr[x] > k) min++;
            ans = min;
        }
        int i = 0;
        for (int j = count; j < n; j++, i++) {
            if (arr[j] > k) min++;
            if (arr[i] > k) min--;
            ans = Math.min(ans, min);
        }
        return ans;
    }
}