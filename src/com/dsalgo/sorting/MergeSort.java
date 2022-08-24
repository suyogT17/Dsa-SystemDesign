package com.dsalgo.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/merge-sort/1
 * Code to do merge sort
 */
class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int start1 = l;
        int start2 = m + 1;
        int[] temp = new int[r - l + 1];
        int x = 0;
        while (start1 <= m || start2 <= r) {
            if (start1 <= m && start2 <= r) {
                if (arr[start1] <= arr[start2]) {
                    temp[x++] = arr[start1];
                    start1++;
                } else {
                    temp[x++] = arr[start2];
                    start2++;
                }
            } else if (start1 <= m) {
                temp[x++] = arr[start1];
                start1++;
            } else if (start2 <= r) {
                temp[x++] = arr[start2];
                start2++;
            }
        }
        for (int i = 0, j = l; i < temp.length; i++, j++) {
            arr[j] = temp[i];
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
}