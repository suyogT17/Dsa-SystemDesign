package com.dsalgo.heaps;

import java.util.PriorityQueue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1
 * You are given an array Arr of size N. You have to find the K-th largest sum of contiguous subarray within the array elements.
 *
 * Example 1:
 *
 * Input:
 * N = 3
 * K = 2
 * Arr = {3,2,1}
 * Output:
 * 5
 * Explanation:
 * The different subarray sums we can get from the array
 * are = {6,5,3,2,1}. Where 5 is the 2nd largest.
 */
class KthLargestSumContegiousSubArrray {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int i = 0; i < Arr.length; i++) {
            int sum = 0;
            for (int j = i; j < Arr.length; j++) {
                sum += Arr[j];
                minHeap.add(sum);
                if (minHeap.size() > K) minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}