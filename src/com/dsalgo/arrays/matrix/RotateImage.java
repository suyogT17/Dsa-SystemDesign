package com.dsalgo.arrays.matrix;

/**
 * Problem Link: https://leetcode.com/problems/rotate-image/
 */
class RotateImage {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int x = 0, y = matrix[i].length - 1; x < y; x++, y--) {
                int temp = matrix[i][x];
                matrix[i][x] = matrix[i][y];
                matrix[i][y] = temp;
            }
        }
    }
}