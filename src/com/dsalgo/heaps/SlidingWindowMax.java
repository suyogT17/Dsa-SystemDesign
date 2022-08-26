package com.dsalgo.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/deee0e8cf9910e7219f663c18d6d640ea0b87f87/1
 * Due to the rise of covid-19 cases in India, this year BCCI decided to organize knock-out matches in IPL rather than a league.
 * Today is matchday 2 and it is between the most loved team Chennai Super Kings and the most underrated team - Punjab Kings. Stephen Fleming, the head coach of CSK,
 * analyzing the batting stats of Punjab. He has stats of runs scored by all N players in the previous season and he wants to find the maximum score for each and every contiguous
 * sub-list of size K to strategize for the game.
 * <p>
 * Example 1:
 * Input:
 * N = 9, K = 3
 * arr[] = 1 2 3 1 4 5 2 3 6
 * Output:
 * 3 3 4 5 5 5 6
 * Explanation:
 * 1st contiguous subarray = {1 2 3} Max = 3
 * 2nd contiguous subarray = {2 3 1} Max = 3
 * 3rd contiguous subarray = {3 1 4} Max = 4
 * 4th contiguous subarray = {1 4 5} Max = 5
 * 5th contiguous subarray = {4 5 2} Max = 5
 * 6th contiguous subarray = {5 2 3} Max = 5
 * 7th contiguous subarray = {2 3 6} Max = 6
 */
class SlidingWindowMax {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((o1, o2) -> o2.getKey() - o1.getKey());
        for (int i = 0; i < n; i++) {
            maxHeap.add(new Pair(arr[i], i));
            if (i >= k - 1) {
                while (!maxHeap.isEmpty() && maxHeap.peek().getValue() < i - k + 1) {
                    maxHeap.poll();
                }
                output.add(maxHeap.peek().getKey());
            }
        }
        return output;
    }
}

class Pair {
    private int key, value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}