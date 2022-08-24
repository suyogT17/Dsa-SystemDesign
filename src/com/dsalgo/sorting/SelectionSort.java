package com.dsalgo.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/selection-sort/1
 * Code to do selection sort
 */
public class SelectionSort {
    void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
