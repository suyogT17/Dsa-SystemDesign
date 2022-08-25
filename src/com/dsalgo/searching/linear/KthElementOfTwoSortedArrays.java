package com.dsalgo.searching.linear;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
 * Given two sorted arrays arr1 and arr2 of size N and M respectively and an element K.
 * The task is to find the element that would be at the k’th position of the final sorted array.
 */
class KthElementOfTwoSortedArrays {
    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int i = 0, j = 0;
        int curr = 0;
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                curr = arr1[i];
                i++;
            } else {
                curr = arr2[j];
                j++;
            }
            k--;
            if (k == 0) {
                return curr;
            }
            // System.out.println(curr+ " "+i+ " "+j);
        }
        if (k > 0 && i < n) {
            return arr1[i + k - 1];
        }
        if (k > 0 && j < m) {
            return arr2[j + k - 1];
        }
        return -1;
    }
}