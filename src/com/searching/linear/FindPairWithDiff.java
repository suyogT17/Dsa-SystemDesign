package com.searching.linear;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 * Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.
 */
class FindPairWithDiff {
    public boolean findPair(int arr[], int size, int n) {
        Arrays.sort(arr);
        int i = 0, j = 1;
        while (i < size && j < size) {
            if (i != j && arr[j] - arr[i] == n) return true;
            else if (arr[j] - arr[i] < n) j++;
            else {
                i++;
            }
        }
        return false;
    }
}