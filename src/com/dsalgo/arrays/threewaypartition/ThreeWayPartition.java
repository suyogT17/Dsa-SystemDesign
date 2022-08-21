package com.dsalgo.arrays.threewaypartition;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
 */
class ThreeWayPartition {
    public void threeWayPartition(int array[], int a, int b) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;
        while (low <= high && array[low] < a) {
            low++;
        }
        while (high >= 0 && array[high] > b) {
            high--;
        }
        mid = low;
        while (mid <= high) {
            if (array[mid] < a) {
                swap(array, low, mid);
                low++;
                mid++;
            } else if (array[mid] > b) {
                swap(array, mid, high);
                high--;
            } else mid++;
        }
    }

    void swap(int array[], int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
