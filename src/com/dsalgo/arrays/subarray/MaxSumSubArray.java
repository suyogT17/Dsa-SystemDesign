package com.dsalgo.arrays.subarray;

/**
 * Problem Link: https://leetcode.com/problems/maximum-subarray/
 * Maximum sum subarray solved using kaden's algo
 * Time: O(N)
 */
class MaxSumSubArray {
    public int maxSubArray(int[] nums) {
        int current = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            // check if the num at i is greater than current+sum if yes then start new sum from num[i] as current is negative
            current = Math.max(nums[i], current+nums[i]);
            //store max sum
            max = Math.max(current, max);
        }
        return max;
    }
}