package com.dsalgo.searching.linear;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * Code to find missing and repeated number in the array
 */
class MissingAndRepeated {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int xorsum = arr[0];
        for (int i = 1; i < n; i++) {
            xorsum ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            xorsum ^= i;
        }
        int set_bit = xorsum & ~(xorsum - 1);
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if ((arr[i] & set_bit) != 0) {
                x ^= arr[i];
            } else y ^= arr[i];
        }
        for (int i = 1; i <= n; i++) {
            if ((i & set_bit) != 0) {
                x ^= i;
            } else y ^= i;
        }
        int xcount = 0, ycount = 0;
        for (int i = 0; i < n; i++) {
            if (x == arr[i]) {
                xcount++;
            }
            if (y == arr[i]) {
                ycount++;
            }
        }
        int[] op = null;
        if (xcount == 0) {
            op = new int[]{y, x};
        } else op = new int[]{x, y};
        return op;
    }
}