package com.dsalgo.arrays.matrix;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/spiral-matrix/submissions/
 */
class SpiralTraversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList();
        int n = matrix.length;
        int m = matrix[0].length;
        int finalCount = matrix.length * matrix[0].length;
        int start = 0;
        int i = 0, j = 0;
        while (output.size() <= finalCount) {
            while (j < m) {
                output.add(matrix[i][j++]);
                if (output.size() == finalCount) return output;
            }
            j--;
            i++;
            while (i < n) {
                output.add(matrix[i++][j]);
                if (output.size() == finalCount) return output;
            }
            i--;
            j--;
            while (j >= start) {
                output.add(matrix[i][j--]);
                if (output.size() == finalCount) return output;
            }
            j++;
            i--;
            while (i >= start + 1) {
                output.add(matrix[i--][j]);
                if (output.size() == finalCount) return output;
            }
            i++;
            j++;
            start++;
            n--;
            m--;
        }
        return output;
    }
}