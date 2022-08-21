package com.dsalgo.arrays;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/common-elements1132/1
 */
class CommonElementsIn3SortedArrays {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> output = new ArrayList();
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) {
            if (A[i] == B[j] && B[j] == C[k]) {
                output.add(A[i]);
                while (i < n1 - 1 && A[i] == A[i + 1]) i++;
                while (j < n2 - 1 && B[j] == B[j + 1]) j++;
                while (k < n3 - 1 && C[k] == C[k + 1]) k++;
                i++;
                j++;
                k++;
            } else if (A[i] <= B[j] && A[i] <= C[k])
                i++;
            else if (B[j] <= A[i] && B[j] <= C[k])
                j++;
            else k++;
        }
        return output;
    }
}