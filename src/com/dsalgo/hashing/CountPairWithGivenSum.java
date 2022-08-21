package com.dsalgo.hashing;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 */
class CountPairWithGivenSum {
    int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap();
        int output = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i])) output += map.get(k - arr[i]);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return output;
    }
}
