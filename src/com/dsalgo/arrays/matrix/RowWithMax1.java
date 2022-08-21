package com.dsalgo.arrays.matrix;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
 */
class RowWithMax1 {
    int rowWithMax1s(int arr[][], int n, int m) {
        int currentMin = 0;
        int row = -1;
        int prev = Integer.MAX_VALUE;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            while (j >= 0 && arr[i][j] == 1) {
                j--;
            }
            if (j == -1) return i;
            else {
                if (j != m - 1 && j < prev) {
                    prev = j;
                    row = i;
                }
            }
            i++;
        }
        return row;
    }
}