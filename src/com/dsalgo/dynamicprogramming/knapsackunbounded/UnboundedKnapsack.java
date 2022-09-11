package com.dsalgo.dynamicprogramming.knapsackunbounded;

/**
 * Problem Link:
 * Unbounded knapsack problem or Rod cutting solved using recursion, memoization and tabulation
 * Time Complexity: O(n*m)
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int w = 10;
        int n = wt.length;
        int output = unboundedKnapsack(wt, val, w, n);
        System.out.println("Unbounded knapsack using recursion: " + output);
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        int memoOutput = unboundedKnapsackMemoization(wt, val, w, n, dp);
        System.out.println("Unbounded knapsack using recursion and memoization: " + memoOutput);
        int tabulationOutput = unboundedKnapsackWithTabulation(wt, val, w, n);
        System.out.println("Unbounded knapsack using tabulation: " + tabulationOutput);
    }

    private static int unboundedKnapsack(int[] wt, int[] val, int w, int n) {
        if (w == 0 || n == 0) return 0;
        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + unboundedKnapsack(wt, val, w - wt[n - 1], n), unboundedKnapsack(wt, val, w, n - 1));
        } else return unboundedKnapsack(wt, val, w, n - 1);
    }

    private static int unboundedKnapsackMemoization(int[] wt, int[] val, int w, int n, int dp[][]) {
        if (w == 0 || n == 0) return 0;
        if (dp[n][w] != -1) return dp[n][w];
        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + unboundedKnapsackMemoization(wt, val, w - wt[n - 1], n, dp), unboundedKnapsackMemoization(wt, val, w, n - 1, dp));
        } else return dp[n][w] = unboundedKnapsackMemoization(wt, val, w, n - 1, dp);
    }

    private static int unboundedKnapsackWithTabulation(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
}