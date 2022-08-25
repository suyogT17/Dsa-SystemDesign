package com.dsalgo.searching.binarysearch;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 * Code to find first and last occurrence of X using binary search
 */
public class FirstAndLastOccurrenceOfX {
    ArrayList<Long> find(long arr[], int n, int x) {
        ArrayList<Long> output = new ArrayList();
        output.add(findLowerBound(arr, n, x));
        output.add(findUpperBound(arr, n, x));
        return output;
    }

    long findLowerBound(long arr[], int n, int x) {
        long left = 0;
        long right = n - 1;
        long index = -1;
        while (left <= right) {
            int mid = (int) (right - left / 2);
            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            if (arr[mid] == x) index = mid;
        }
        return index;
    }

    long findUpperBound(long arr[], int n, int x) {
        long left = 0;
        long right = n - 1;
        long index = -1;
        while (left <= right) {
            int mid = (int) (right - left / 2);
            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            if (arr[mid] == x) index = mid;
        }
        return index;
    }
}