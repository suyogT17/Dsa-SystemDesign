package com.dsalgo.heaps;

import java.util.PriorityQueue;

/**
 * Problem Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) heap.poll();
        }
        int kth = heap.poll();
        return kth;
    }
}