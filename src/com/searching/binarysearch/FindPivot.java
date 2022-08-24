package com.searching.binarysearch;

/**
 * Problem Link: https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/pivot-sorted-rotated-array-official/ojquestion
 * 1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
 * 2. You have to find the smallest element in O(logN) time-complexity
 */
public class FindPivot {
    public static int findPivot(int[] arr) {
        int left = 0, right = arr.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= arr[left]) {
                left = mid + 1;
            } else right = mid;
        }
        return right;
    }
}