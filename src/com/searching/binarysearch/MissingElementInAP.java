package com.searching.binarysearch;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/missing-element-of-ap2228/1
 * Find the missing element from an ordered array arr[], consisting of N elements representing an Arithmetic Progression(AP).
 * Note: There always exists an element which upon inserting into sequence forms Arithmetic progression.
 */
class MissingElementInAP {
    int findMissing(int[] arr) {
        int left = 0, right = arr.length - 1;
        int diff = ((arr[arr.length - 1] - arr[0]) / arr.length);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid + 1] - arr[mid] != diff) {
                return arr[mid] + diff;
            } else if (mid > 0 && (arr[mid] - arr[mid - 1]) != diff) {
                return arr[mid - 1] + diff;
            } else if (arr[mid] == (arr[0] + (diff * mid))) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return -1;
    }
}
