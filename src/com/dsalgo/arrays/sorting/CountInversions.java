package com.dsalgo.arrays.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */
class CountInversions {
    static long inversionCount(long arr[], long N) {
        long ans = runMergeSort(arr, 0, arr.length - 1);
        return ans;
    }

    static long runMergeSort(long arr[], int start, int end) {
        long inversions = 0;
        if (start < end) {
            int mid = start + (end - start) / 2;
            inversions += runMergeSort(arr, start, mid);
            inversions += runMergeSort(arr, mid + 1, end);
            inversions += merge(arr, start, mid + 1, end);
        }
        return inversions;
    }

    static long merge(long arr[], int start, int mid, int end) {
        long inversions = 0;
        long temp[] = new long[end - start + 1];
        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];

            } else {
                temp[k++] = arr[j++];
                inversions += (mid - i); //because for the j'th element all the other element from i are greater and inversions
            }
        }
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (int x = 0, y = start; x < temp.length; x++, y++) {
            arr[y] = temp[x];
        }
        return inversions;
    }
}