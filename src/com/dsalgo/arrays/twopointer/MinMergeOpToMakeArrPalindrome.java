package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://techiedelight.com/practice/?problem=MinimumMergeOperations
 */
class MinMergeOpToMakeArrPalindrome {
    public static int findMin(int[] nums) {
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (nums[i] == nums[j]) {
                i++;
                j--;
            } else if (nums[i] > nums[j]) {
                j--;
                nums[j] += nums[j + 1];
                ans++;
            } else {
                i++;
                nums[i] += nums[i - 1];
                ans++;
            }
        }
        return ans;
    }
}
