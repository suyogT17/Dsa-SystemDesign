package com.dsalgo.hashing;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
 */
class SubArraySum0 {
    static boolean findsum(int arr[], int n) {
        int sum = 0;
        Set<Integer> set = new HashSet();
        set.add(0);
        for (int num : arr) {
            if (set.contains(sum + num)) return true;   // check if current sum contains in the array or not
            else {
                sum += num; // add the current element to the sum
                set.add(sum);   // add current sum to the set
            }
        }
        return false;
    }
}