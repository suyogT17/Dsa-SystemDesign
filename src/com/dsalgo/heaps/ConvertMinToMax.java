package com.dsalgo.heaps;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/convert-min-heap-to-max-heap_630293
 */
public class ConvertMinToMax {
    public static void minHeapToMaxHeap(long[] arr) {
        // Your code goes here.
        for(int i=((arr.length)/2-1);i>=0;i--){
            maxHeapify(arr, i, arr.length);
        }

    }

    static void maxHeapify(long[] arr, int start, int end){
        int left = 2*start+1;
        int right =  2*start+2;
        int largest = start;

        if(left < end && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < end && arr[right] > arr[largest]){
            largest = right;
        }

        if(start != largest){
            swap(arr, start, largest);
            maxHeapify(arr, largest, end);
        }
    }

    static void swap(long[] arr, int i, int j){
        long temp =  arr[i];
        arr[i] =  arr[j];
        arr[j] = temp;
    }
}
