package com.dsalgo.arrays.twopointer;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 */
class FindMinDiff {
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int i = 1;
        long diff = a.get(m - 1) - a.get(0);
        while (m < n) {
            if (a.get(m) - a.get(i) < diff) diff = a.get(m) - a.get(i);
            m++;
            i++;
        }
        return diff;
    }
}