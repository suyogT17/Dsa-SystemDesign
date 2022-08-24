package com.dsalgo.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/quick-sort/1
 * Code to do quick sort
 */
class QuickSort {
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    static int partition(int arr[], int low, int high) {
        int pivotLoc = low;
        int pivot = arr[high];
        int i = low;
        while (i <= high) {
            if (arr[i] < pivot) {
                swap(arr, i, pivotLoc);
                pivotLoc++;
            }
            i++;
        }
        swap(arr, high, pivotLoc);
        return pivotLoc;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
