package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Problem Link:
 * Equal sum partition based on subset sum
 */
public class EqualSumPartition {
    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        boolean isPartitionPossible = false;
        if (sum % 2 == 0) {           // if sum is even then only equal sum partition is possible
            int sumToFind = sum / 2;  // check if sum/2 is achieved or not
            System.out.println("Sum to Find: " + sumToFind);
            boolean[][] dp = new boolean[n + 1][sumToFind + 1];
            isPartitionPossible = SubsetSum.solveSubsetSumWithTabulation(nums, sumToFind, n, dp);
        }
        System.out.println("Is Equal Sum Partition Available: " + isPartitionPossible);
    }
}