package com.dsalgo.arrays.twopointer;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/4sum/
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 */
class FourSumProblem {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new LinkedList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        List<Integer> list = new ArrayList();
                        list.addAll(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) k++;
                        while (l > k && nums[l] == nums[k - 1]) l--;
                        k++;
                        l--;
                        output.add(list);
                    } else if (nums[i] + nums[j] + nums[k] + nums[l] < target) k++;
                    else l--;
                }
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return output;
    }
}