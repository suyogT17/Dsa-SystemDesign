package com.dsalgo.arrays.matrix;

/**
 * Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
 */
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}