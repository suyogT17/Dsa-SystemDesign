package com.dsalgo.graph.dp;

/**
 * Problem Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * Solved using memoization
 * Time: O(n*m)
 */
class LongestIncreasingPathInMatrix {
    int m,n;
    public int longestIncreasingPath(int[][] matrix) {
        this.m = matrix.length;
        this.n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = dfs(i,j, matrix,dp);

                ans = Math.max(ans, dp[i][j]);

            }
        }
        return ans;
    }

    int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j] > 0) return dp[i][j];
        int max = 0;
        if(isSafe(i,j,i-1, j, matrix)){
            max= Math.max(max,dfs(i-1, j, matrix, dp));
        }

        if(isSafe(i,j,i, j-1, matrix)){
            max= Math.max(max,dfs(i, j-1, matrix, dp));

        }

        if(isSafe(i,j,i+1, j, matrix)){
            max= Math.max(max,dfs(i+1, j, matrix, dp));

        }

        if(isSafe(i,j,i, j+1, matrix)){
            max= Math.max(max,dfs(i, j+1, matrix, dp));

        }
        dp[i][j] = max+1;
        return dp[i][j];
    }

    boolean isSafe(int oldi, int oldj, int i , int j, int[][] matrix){
        if(i >= 0 && i< m && j >=0 && j < n && matrix[i][j] > matrix[oldi][oldj]){
            return true;
        }
        return false;
    }
}