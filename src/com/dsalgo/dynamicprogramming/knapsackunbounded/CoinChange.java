package com.dsalgo.dynamicprogramming.knapsackunbounded;

/**
 * Problem Link:
 * Coin change problem - maximum number of ways to create given sum
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 5;
        int n = coins.length;
        int maxWays = solveCoinChange(coins, sum,n);
        System.out.println("Max ways: "+maxWays);
    }

    private static int solveCoinChange(int[] coins, int sum, int n){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j ==0) dp[i][j] = 1;
                else if(i ==0) dp[i][j] = 0;
                else if(coins[i-1] <= j) dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
