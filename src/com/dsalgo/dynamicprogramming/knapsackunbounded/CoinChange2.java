package com.dsalgo.dynamicprogramming.knapsackunbounded;

/**
 * Problem Link:
 * Coin change problem - minimum number of coins required to create given sum
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {2,2,1};
        int sum = 5;
        int n = coins.length;
        int coinsRequired = countMinCoins(coins, sum, n);
        System.out.println("Minimum coins required: " +coinsRequired);
    }

    private static int countMinCoins(int[] coins, int sum , int n){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i == 0) dp[i][j] = Integer.MAX_VALUE-1;
                else if(j == 0) dp[i][j] = 0;
                else if(i == 1){
                    if(j%coins[i] == 0) dp[i][j] = j/coins[i];
                    else dp[i][j] = Integer.MAX_VALUE-1;
                }
                else if(coins[i-1] <= j) dp[i][j] = Math.min(1+dp[i][j-coins[i-1]], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}