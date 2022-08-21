package com.dsalgo.arrays.subseqence;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 */
class LongestConsecutiveSubseq {
    static int findLongestConseqSubseq(int arr[], int N) {
        Set<Integer> set = new HashSet();
        for (int n : arr) {
            set.add(n);
        }
        int max = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentMax = 1;
                while (set.contains(currentNum + 1)) {
                    currentMax++;
                    currentNum = currentNum + 1;
                }
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }
}