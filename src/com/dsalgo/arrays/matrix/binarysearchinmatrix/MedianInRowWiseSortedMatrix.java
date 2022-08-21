package com.dsalgo.arrays.matrix.binarysearchinmatrix;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
 */
class MedianInRowWiseSortedMatrix {
    int median(int matrix[][], int r, int c) {
        int low = 1;
        int high = (int) 1e9;
        while (low <= high) {
            int mid = (high + low) / 2;
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                count += findSmallerThenMid(matrix[i], mid);
            }
            if (count <= (r * c) / 2) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    private int findSmallerThenMid(int mat[], int mid) {
        int low = 0;
        int high = mat.length - 1;
        while (low <= high) {
            int i = (high + low) / 2;
            if (mat[i] <= mid) low = i + 1;
            else high = i - 1;
        }
        return low;
    }
}