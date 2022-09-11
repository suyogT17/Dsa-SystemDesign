package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Problem Link:
 * Count subset of given sum using tabulation
 * Time complexity:  O(n*w) -> n = number of elements , w = sum
 */
public class CountSubset {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int n = arr.length;
        int w = 3;
        int outputRec = countSubsetRecursion(arr, w, n);
        System.out.println("output with recursion = " + outputRec);
        int[][] dp = new int[n + 1][w + 1];
        //call for memoization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        System.out.println("output with recursion with memoization = " + countSubsetRecursionWithMemoization(arr, w, n, dp));
        dp = new int[n + 1][w + 1];
        System.out.println("output with tabulation = " + countSubsetTabulation(arr, w, n, dp));
    }

    private static int countSubsetRecursion(int[] arr, int w, int n) {
        if (w == 0) return 1;
        if (n == 0) return 0;
        if (arr[n - 1] <= w)
            return countSubsetRecursion(arr, w - arr[n - 1], n - 1) + countSubsetRecursion(arr, w, n - 1);
        else return countSubsetRecursion(arr, w, n - 1);
    }

    private static int countSubsetRecursionWithMemoization(int[] arr, int w, int n, int[][] dp) {
        if (w == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][w] != -1) return dp[n][w];
        if (arr[n - 1] <= w)
            return dp[n][w] = countSubsetRecursionWithMemoization(arr, w - arr[n - 1], n - 1, dp) + countSubsetRecursionWithMemoization(arr, w, n - 1, dp);
        else return dp[n][w] = countSubsetRecursionWithMemoization(arr, w, n - 1, dp);
    }

    protected static int countSubsetTabulation(int[] arr, int w, int n, int[][] dp) {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (i == 0) dp[i][j] = 0;
                else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
}