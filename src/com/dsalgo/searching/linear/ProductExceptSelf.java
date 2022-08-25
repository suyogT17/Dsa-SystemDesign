package com.dsalgo.searching.linear;

/**
 * Problem Link: https://leetcode.com/problems/product-of-array-except-self/
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        temp[n - 1] = 1;
        int[] op = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            temp[i] = temp[i + 1] * nums[i + 1];
        }
        int prod = 1;
        for (int i = 0; i < n; i++) {
            op[i] = temp[i] * prod;
            prod *= nums[i];
        }
        return op;
    }
}