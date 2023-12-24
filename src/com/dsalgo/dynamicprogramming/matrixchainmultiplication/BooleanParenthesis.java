package com.dsalgo.dynamicprogramming.matrixchainmultiplication;

import java.util.HashMap;
import java.util.Map;

public class BooleanParenthesis {

    static Map<String, Integer> dp = new HashMap();

    static int countWays(int N, String S) {
        dp.clear();
        return solve(S, 0, S.length() - 1, true);//*solve(S,0,S.length()-1, false);
    }

    private static int solve(String S, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue && S.charAt(i) == 'T') return 1;
            else if (!isTrue && S.charAt(i) == 'F') return 1;
            else return 0;
        }
        if (dp.containsKey(i + "_" + j + "_" + isTrue)) return dp.get(i + "_" + j + "_" + isTrue);
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int lt = solve(S, i, k - 1, true) % 1003;
            int lf = solve(S, i, k - 1, false) % 1003;
            int rt = solve(S, k + 1, j, true) % 1003;
            int rf = solve(S, k + 1, j, false) % 1003;
            if (S.charAt(k) == '&') {
                if (isTrue) {
                    ans = (ans % 1003 + (lt * rt) % 1003) % 1003;
                } else ans = (ans % 1003 + (lt * rf) % 1003 + (lf * rt) % 1003 + (lf * rf) % 1003) % 1003;
            } else if (S.charAt(k) == '|') {
                if (isTrue) {
                    ans = (ans % 1003 + (lt * rf) % 1003 + (lf * rt) % 1003 + (lt * rt) % 1003) % 1003;
                } else ans = (ans % 1003 + (lf * rf) % 1003) % 1003;
            } else if (S.charAt(k) == '^') {
                if (isTrue) {
                    ans = (ans % 1003 + (lt * rf) % 1003 + (rt * lf) % 1003) % 1003;
                } else ans = (ans % 1003 + (lt * rt) % 1003 + (lf * rf) % 1003) % 1003;
            }
        }
        dp.put(i + "_" + j + "_" + isTrue, ans % 1003);
        return ans % 1003;
    }
}

