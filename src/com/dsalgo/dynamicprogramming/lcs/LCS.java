package com.dsalgo.dynamicprogramming.lcs;

public class LCS {
    public static void main(String args[]) {
        String text1 = "abcdefr";
        String text2 = "zfbcfrr";
        int n = text1.length();
        int m = text2.length();
        int outputRec = lcs(text1, text2, n,m);
        System.out.println("Output with recursion: "+outputRec);
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j] = -1;
            }
        }
        int outputMemoization = lcsWithMemoization(text1, text2, n,m, dp);
        System.out.println("Output with recursion and memoization: "+outputMemoization);
        int outputTabulation = lcsWithTabulation(text1, text2, n, m);
        System.out.println("Output with tabulation: "+outputTabulation);
    }

    static int lcs(String text1, String text2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return 1 + lcs(text1, text2, n - 1, m - 1);
        } else return Math.max(lcs(text1, text2, n, m - 1), lcs(text1, text2, n - 1, m));
    }

    static int lcsWithMemoization(String text1, String text2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) return dp[n][m];
        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return dp[n][m] = 1 + lcsWithMemoization(text1, text2, n - 1, m - 1, dp);
        } else
            return dp[n][m] = Math.max(lcsWithMemoization(text1, text2, n, m - 1, dp), lcsWithMemoization(text1, text2, n - 1, m, dp));
    }

    static int lcsWithTabulation(String text1, String text2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        int i = n, j=m;
        String lcs= "";
        while(i > 0  && j >0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                lcs = text1.charAt(i-1) + lcs;
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] >  dp [j][j-1]){
                    i--;
                }
                else j--;
            }
        }
        System.out.println("LCS : "+lcs);
        return dp[n][m];
    }
}