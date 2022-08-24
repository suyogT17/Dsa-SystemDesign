package com.dsalgo.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/bubble-sort/1
 * Code to do bubble sort
 */
public class BubbleSort {
    public static void bubbleSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
