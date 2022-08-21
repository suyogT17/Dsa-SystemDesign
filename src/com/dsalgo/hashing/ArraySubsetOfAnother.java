package com.dsalgo.hashing;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
 * Approaches:
 * brute force using 2 loops
 * using sorting and binary search
 * using hashing
 */
class ArraySubsetOfAnother {
    public String isSubset(long a1[], long a2[], long n, long m) {
        Set<Long> set = new HashSet();
        for (long a : a1) {
            set.add(a);
        }
        boolean ans = true;
        for (long a : a2) {
            ans = !set.add(a);
            if (!ans) return "No";
        }
        return (ans == true) ? "Yes" : "No";
    }
}