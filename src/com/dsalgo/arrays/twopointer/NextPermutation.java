package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://leetcode.com/problems/next-permutation/
 */
class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void reverse(int nums[], int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int nums[], int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}