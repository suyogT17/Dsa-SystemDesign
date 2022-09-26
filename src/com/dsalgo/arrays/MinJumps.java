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
        if (arr[0] == 0) return -1; // if first position contains 0 it means we can go to next element so we can reach the end
        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jump;  // if we managed to reach the end then return jumps taken
            maxReach = Math.max(maxReach, i + arr[i]);  // check max position we can reach by adding steps at each position

            steps--;    // reduce steps as we move forward
            if (steps == 0) { // if steps reached to 0 that means its time to take next jump
                jump++;     // increment jump
                if (maxReach < i) return -1; // check if we can reach current position or not then only we can move forward else return -1 (we can reach to end)
                steps = maxReach - i; // if we are able to reach the current position then reduce currently travelled positions from them and to find remaining steps
            }
        }
        return -1;
    }
}