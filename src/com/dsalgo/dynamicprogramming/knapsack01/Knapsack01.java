package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Problem Link:
 * Code to solve 0/1 knapsack using recursion, memoization and tabulation
 * Time Complexity = n*m
 * Approach to solve:
 * Recursion -> Memoization -> Tabulation
 */

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int W = 7;
        int n = wt.length;
        int output = solveO1KnapSack(wt, val, W, n);
        System.out.println("output: " + output);
        int[][] dp = new int[n + 1][W + 1];
        //generating result using memoization (Bottom-Up Approach)
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int outputWithMemoization = solveO1KnapSackMemoization(wt, val, W, n, dp);
        System.out.println("output with memoization: " + outputWithMemoization);
        //generating result using tabulation (Top-Down Approach)
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }
        int outputWithTabulation = solve01KnapSackTabulation(wt, val, W, n, dp);
        System.out.println("output with tabulation: " + outputWithTabulation);
    }

    private static int solveO1KnapSack(int[] wt, int[] val, int W, int n) {
        //base condition
        if (n == 0 || W == 0) return 0; // if no item given or out bag weight is 0 then max profit we can derive is 0
        if (wt[n - 1] <= W) {
            //get max by including the element in the bag or by not including
            return Math.max(val[n - 1] + solveO1KnapSack(wt, val, W - wt[n - 1], n - 1), solveO1KnapSack(wt, val, W, n - 1));
        }
        // if weight of item is greater than the bag weight then can't add that item
        else return solveO1KnapSack(wt, val, W, n - 1);
    }

    private static int solveO1KnapSackMemoization(int[] wt, int[] val, int W, int n, int dp[][]) {
        //base condition
        if (n == 0 || W == 0) return 0; // if no item given or out bag weight is 0 then max profit we can derive is 0
        if (dp[n][W] != -1) return dp[n][W];
        if (wt[n - 1] <= W) {
            //get max by including the element in the bag or by not including
            return dp[n][W] = Math.max(val[n - 1] + solveO1KnapSackMemoization(wt, val, W - wt[n - 1], n - 1, dp), solveO1KnapSackMemoization(wt, val, W, n - 1, dp));
        }
        // if weight of item is greater than the bag weight then can't add that item
        else return dp[n][W] = solveO1KnapSackMemoization(wt, val, W, n - 1, dp);
    }

    private static int solve01KnapSackTabulation(int[] wt, int[] val, int W, int n, int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                //base condition
                if (i == 0 || j == 0) dp[i][j] = 0;
                    //get max by including the element in the bag or by not including
                else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j]; // if weight of item is greater than the bag weight then can't add that item
            }
        }
        return dp[n][W];
    }
}