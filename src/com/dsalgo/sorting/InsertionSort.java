package com.dsalgo.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/insertion-sort/1
 * Code to do insertion sort
 */
public class InsertionSort {
    public void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else break;
            }
            arr[j + 1] = temp;
        }
    }
}

