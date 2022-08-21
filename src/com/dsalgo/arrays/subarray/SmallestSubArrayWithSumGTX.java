package com.dsalgo.arrays.subarray;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 */
class SmallestSubArrayWithSumGTX {
    public static int smallestSubWithSum(int a[], int n, int x) {
        int i=0, j=0;
        int sum = 0;
        int len= Integer.MAX_VALUE;
        while(j <n){
            sum+= a[j];
            if(sum > x){
                //len = Math.max(len, j-i+1);
                while(i < j && sum-a[i] > x){
                    sum -= a[i++];
                }
                len = Math.min(len, j-i+1);

            }
            j++;
        }
        return len;

    }
}

