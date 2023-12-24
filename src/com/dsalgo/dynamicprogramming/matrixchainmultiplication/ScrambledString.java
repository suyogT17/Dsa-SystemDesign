package com.dsalgo.dynamicprogramming.matrixchainmultiplication;

import java.util.*;

public class ScrambledString {
    Map<String, Boolean> dp = new HashMap(); //dp map

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() <= 1) return false;
        if (dp.containsKey(s1 + "_" + s2)) return dp.get(s1 + "_" + s2);
        int n = s1.length();
        boolean isScrambled = false;
        for (int i = 1; i < n; i++) {
            if ((isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, n), s2.substring(i, n))) || //for un-swapped scenario
                    (isScramble(s1.substring(0, i), s2.substring(n - i, n)) && isScramble(s1.substring(i, n), s2.substring(0, n - i)))) { // for swapped scenario
                isScrambled = true;
                break;
            }
        }
        dp.put(s1 + "_" + s2, isScrambled);
        return isScrambled;
    }
}
