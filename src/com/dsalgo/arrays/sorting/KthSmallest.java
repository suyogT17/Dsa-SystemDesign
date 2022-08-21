package com.dsalgo.arrays.sorting;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
 * Solved using quick select approach
 * Time: O(KLogN)
 * - in this approach we will find the smallest element till k-1 as we want kth smallest element
 */
class KthSmallest{
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        int pivot = partition(arr, l, r);
        if(pivot == k-1) return arr[pivot]; // after sorting k-1 elements we will return
        else if(pivot < k-1) return kthSmallest(arr, pivot+1, r, k);
        else return kthSmallest(arr, l, pivot-1, k);
    }

    private static int partition(int arr[], int l, int r){
        int pivotLoc = l;
        int pivotEl = arr[r];

        for(int i=l;i<=r;i++){
            if(arr[i] < pivotEl){
                swap(arr, pivotLoc, i);
                pivotLoc++;
            }
        }
        swap(arr, pivotLoc, r);
        return pivotLoc;
    }

    static void swap(int[] arr, int i, int j){
        int temp =  arr[i];
        arr[i] =  arr[j];
        arr[j] =  temp;
    }
}
