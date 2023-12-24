package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Leetcode https://leetcode.com/problems/target-sum/submissions/
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n =  nums.length;
        int total = 0;
        int zeros = 0;
        for (int num : nums) {
            if(num == 0 ) zeros++;
            total += num;
        }

        if(total <  Math.abs(target) || (target+total) %2 != 0) return 0;  // total is less than target or if target + total is not even then not possible to get the target sum

        int w = (total + target)/2;

        int dp[][] = new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j = 0;j<w+1;j++){
                if(j == 0 ) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = 0;
                else if(nums[i-1] <= j && nums[i-1] != 0){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return (int)Math.pow(2, zeros)*dp[n][w];
    }
}
