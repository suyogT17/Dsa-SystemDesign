package com.dsalgo.dynamicprogramming.matrixchainmultiplication;

public class BooleanParenthesis {

        static int countWays(int N, String S){
            // code here
            return solve(S,0,S.length()-1, true);
        }

        private static int solve(String S, int i, int j, boolean isTrue){
            if(i>j) return 0;

            if(i == j){
                if(isTrue && S.charAt(i) == 'T') return 1;
                else if (!isTrue && S.charAt(i) == 'F') return 1;
                else return 0;
            }
            int ans = 0;
            for(int k=i+1;k<j;k+=2){
                int lt = solve(S,i,k-1,true);
                int lf = solve(S,i,k-1,false);
                int rt = solve(S,k+1,j,true);
                int rf = solve(S,k+1,j,false);
                if(S.charAt(k) == '&'){
                    if(isTrue){
                        ans += lt * rt;
                    }
                    else ans += lt*rf + lf*rt + lf*rf;
                }
                else if(S.charAt(k) == '|'){
                    if(isTrue){
                        ans += lt*rf + lf*rt + lt*rt;
                    }
                    else ans += lf*rf;
                }
                else if(S.charAt(k) == '^'){
                    if(isTrue){
                        ans += lt * rf + rt * lf;
                    }
                    else ans += lt*rt + lf*rf;
                }
            }
            return ans;
        }
    }

