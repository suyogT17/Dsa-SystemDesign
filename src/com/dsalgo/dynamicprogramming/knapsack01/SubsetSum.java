package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Problem Link:
 * Subset sum problem solved using recursion, memoization and tabulation
 * Time Complexity: n*w;
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int n = arr.length;
        int w = 19;
        boolean output = solveSubsetSumRec(arr, w, n);
        System.out.println("Output With Recursion: " + output);
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                dp[i][j] = -1;
            }
        }
        int outputMemoization = solveSubsetSumRecWithMemo(arr, w, n, dp);
        System.out.println("Output With Recursion-Memoization: " + ((outputMemoization == 1) ? true : false));
        boolean[][] boolDp = new boolean[n + 1][w + 1];
        boolean outputTabulation = solveSubsetSumWithTabulation(arr, w, n, boolDp);
        System.out.println("Output With Tabulation: " + outputTabulation);
    }

    private static boolean solveSubsetSumRec(int[] arr, int w, int n) {
        if (w == 0) return true;  // if weight is 0 then it can be achieved without any element
        if (n == 0) return false; // if number of items given are 0 then we can't achieve sum
        if (arr[n - 1] <= w)      // if element is less than weight
            return solveSubsetSumRec(arr, w - arr[n - 1], n - 1) || solveSubsetSumRec(arr, w, n - 1);  // sum can be achieved by adding the current weight or not adding the weight
        else return solveSubsetSumRec(arr, w, n - 1);  // if current element is greater than weight then we can't pick
    }

    private static int solveSubsetSumRecWithMemo(int[] arr, int w, int n, int[][] dp) {
        if (w == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][w] != -1) return dp[n][w];
        if (arr[n - 1] <= w)
            return dp[n][w] = Math.max(solveSubsetSumRecWithMemo(arr, w - arr[n - 1], n - 1, dp), solveSubsetSumRecWithMemo(arr, w, n - 1, dp));
        else return dp[n][w] = solveSubsetSumRecWithMemo(arr, w, n - 1, dp);
    }

    protected static boolean solveSubsetSumWithTabulation(int[] arr, int w, int n, boolean[][] dp) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j == 0) dp[i][j] = true;
                else if (i == 0) dp[i][j] = false;
                else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
}