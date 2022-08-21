package com.dsalgo.arrays.subarray;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 */
class MaxProduct {
    long maxProduct(int[] arr, int n) {
        if (arr == null || arr.length == 0) return 0;
        long max = arr[0], min = arr[0], result = arr[0];
        for (int i = 1; i < n; i++) {
            long prevMax = max;
            max = Math.max(Math.max(max * arr[i], min * arr[i]), arr[i]);
            min = Math.min(Math.min(prevMax * arr[i], min * arr[i]), arr[i]);
            if (result < max) result = max;
        }
        return result;
    }
}