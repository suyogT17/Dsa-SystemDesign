package com.dsalgo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
 * Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.
 *
 * Example 1:
 *
 * Input:
 * N = 4
 * X[] = 5,15,1,3
 * Output:
 * 5
 * 10
 * 5
 * 4
 * Explanation:Flow in stream : 5, 15, 1, 3
 * 5 goes to stream --> median 5 (5)
 * 15 goes to stream --> median 10 (5,15)
 * 1 goes to stream --> median 5 (5,15,1)
 * 3 goes to stream --> median 4 (5,15,1 3)
 */
class FindMedianInStream {
    //Function to insert heap.
    static PriorityQueue<Integer> minHeap = new PriorityQueue();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void insertHeap(int x) {
        // add your code here
        if (maxHeap.isEmpty() || maxHeap.peek() >= x) {
            maxHeap.add(x);
        } else {
            minHeap.add(x);
        }
        balanceHeaps();
    }

    //Function to balance heaps.
    public static void balanceHeaps() {
        // add your code here
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    //Function to return Median.
    public static double getMedian() {
        // add your code here
        if ((maxHeap.size() + minHeap.size()) % 2 == 0) {
            return (double) ((maxHeap.peek() + minHeap.peek()) / 2);
        } else {
            return (double) maxHeap.peek();
        }
    }
}