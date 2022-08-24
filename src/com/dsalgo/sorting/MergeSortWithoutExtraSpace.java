package com.dsalgo.sorting;

/**
 * Problem: Merge sort without extra space
 */
class MergeSortWithoutExtraSpace {
    void merge(int arr[], int l, int m, int r) {
        int start1 = l;
        int start2 = m + 1;
        while (start1 <= m && start2 <= r) {
            if (arr[start1] <= arr[start2]) {
                start1++;
            } else {
                int value = arr[start2];
                int index = start2;
                while (index != start1) {   //shifting all the elements to right
                    arr[index] = arr[index - 1];
                    index--;
                }
                arr[start1] = value;
                start1++;
                m++;
                start2++;
            }
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
