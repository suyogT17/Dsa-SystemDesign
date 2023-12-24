package com.dsalgo.dynamicprogramming.onedimdp;

import java.util.Arrays;

public class ClimbStairs {
        int[] dp = new int[46];

        public int climbStairs(int n) {
            Arrays.fill(dp, -1);
            return solve(n);
        }

        private int solve(int n){
            if(n == 0) return 1;
            if(n < 0 ) return 0;
            if(dp[n] != -1) return dp[n];
            return dp[n] = solve(n-1) + solve(n-2);
        }

        private int solveTabulation(int n){
            int dp[] = new int[n+1];
            for(int i=0;i<=n;i++){
                if(i == 0) dp[i] = 0;
                else {
                    dp[i] = dp[i-1] + dp[i-2];
                }
            }
            return dp[n];
        }
}
