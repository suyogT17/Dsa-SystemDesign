package com.dsalgo.arrays.twopointer;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 */
public class TripletSum {
    public static boolean find3Numbers(int A[], int n, int X) {
        Arrays.sort(A);
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (A[i] + A[j] + A[k] == X) return true;
                else if ((A[i] + A[j] + A[k] < X)) j++;
                else k--;
            }
        }
        return false;
    }
}