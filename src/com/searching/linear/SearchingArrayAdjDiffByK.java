package com.searching.linear;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1
 * Searching in an array where adjacent differ by at most k
 */
class SearchingArrayAdjDiffByK {
    public static int search(int arr[], int n, int x, int k) {
        int i = 0;
        while (i < n) {
            if (arr[i] == x) return i;
            i = i + Math.max(1, Math.abs(arr[i] - x) / k);
        }
        return -1;
    }
}


