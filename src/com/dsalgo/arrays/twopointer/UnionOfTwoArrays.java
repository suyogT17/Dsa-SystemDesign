package com.dsalgo.arrays.twopointer;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1
 * Union of two arrays
 * Approaches:
 *  Approach 1:
 *  Time: O((N+M)Log(N+M)), where N = length of arr1, M= length of arr2
 *      - Merge the two arrays and store them in the new array whose length =  len(arr1) + len(arr2)
 *      - Sort the new array
 *      - count the unique elements
 *  Approach 2 and Approach 3 are based on problem https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 */
class UnionOfTwoArrays{
    public static int doUnion(int a[], int n, int b[], int m)
    {
        //Your code here
        int[] completeArray =  new int[m+n];
        int index = 0;
        for(int i=0;i<n;i++){
            completeArray[index] = a[i];
            index++;
        }

        for(int i=0;i<m;i++){
            completeArray[index] = b[i];
            index++;
        }

        Arrays.sort(completeArray);
        int count = 1;
        for(int i=1;i<completeArray.length;i++){
            if(completeArray[i-1] != completeArray[i]){
                count++;
            }
        }
        return count;
    }
}