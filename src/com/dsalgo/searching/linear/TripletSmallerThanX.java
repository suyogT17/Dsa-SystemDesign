package com.dsalgo.searching.linear;

import java.util.*;
/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
 * Given an array arr[] of distinct integers of size N and a value sum,
 * the task is to find the count of triplets (i, j, k), having (i<j<k) with the sum of (arr[i] + arr[j] + arr[k]) smaller than the given value sum.
 */
class TripletSmallerThanX {
    //time complexity n2
    long countTriplets(long arr[], int n, int sum) {
        Arrays.sort(arr);
        long ans = 0L;
        for (int i = 0; i < n - 2; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                if (arr[i] + arr[start] + arr[end] < sum) {
                    ans += end - start;
                    start++;
                } else if (arr[i] + arr[start] + arr[end] >= sum) {
                    end--;
                }
            }
        }
        return ans;
    }
}