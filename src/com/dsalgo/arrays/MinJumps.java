package com.dsalgo.arrays;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 */
class MinJumps {
    static int minJumps(int[] arr) {
        // your code here
        if (arr.length == 1) return arr[0];
        int n = arr.length;
        int steps = arr[0];
        int maxReach = arr[0];
        int jump = 1;
        if (arr[0] == 0) return -1;
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jump;
            maxReach = Math.max(maxReach, i + arr[i]);

            steps--;
            if (steps == 0) {
                jump++;
                if (maxReach < i) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }
}