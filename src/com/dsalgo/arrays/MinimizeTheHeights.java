package com.dsalgo.arrays;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
 * Minimize the difference between element
 * Time : O(NlogN)
 *
 */
public class MinimizeTheHeights {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr); // sort the array
        // we are assigning in the below way because we have to reduce the diff
        int min = arr[0]+k, max = arr[n-1]-k;   // min will first element+k; max will be last element-k
        int diff = arr[n - 1] - arr[0];         // current diff will be last element - first element

        for(int i=1;i<n;i++){
            /**
             * here as our array is sorted in asc manner i-1 element is smaller than i
             * so to reduce diff we are subtracting k from bigger element and adding k to smaller element
             */
            int mi = Math.min(min, arr[i]-k);   // to find mi we will subtract k from current element
            int ma = Math.max(max, arr[i-1]+k); // to find ma we will add k to prev element
            if(mi < 0) continue; // is minimum is negative then it's invalid case as per question constraints

            if(ma -mi < diff) diff =  ma-mi; // check current ma-mi less than diff or not if yes then assign it to diff
        }
        return diff;
    }
}
