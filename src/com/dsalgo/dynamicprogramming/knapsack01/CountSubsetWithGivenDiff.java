package com.dsalgo.dynamicprogramming.knapsack01;

/**
 * Problem Link:
 * Count subset with given diff solved using subset sum
 * Target sum
 * Time Complexity: O(n*w)
 * equation 1 : s1 + s2 = sum of arr
 * equation 2 : s1 - s2 = diff
 * total      : 2s1 = (sum of arr + diff)
 * sum 1 and 2 to find w = (diff + sum of arr)/2
 * find count of subset with w.
 */
public class CountSubsetWithGivenDiff {
    public static void main(String[] args) {
        int[] arr = {1};
        int n = arr.length;
        int total = 0;
        int diff = 2;
        for (int num : arr) {
            total += num;
        }
        int w = (int) Math.ceil((double)(total + diff) / 2.0);
        int[][] dp = new int[n + 1][w + 1];
        System.out.println("output with tabulation = " + CountSubset.countSubsetTabulation(arr, w, n, dp));
    }
}
