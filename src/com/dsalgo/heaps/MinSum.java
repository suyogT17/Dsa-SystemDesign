package com.dsalgo.heaps;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-sum4058/1
 * Given an array Arr of size N such that each element is from the range 0 to 9. Find the minimum possible sum of two numbers formed using the elements of the array. All digits in the given array must be used to form the two numbers.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 6
 * Arr[] = {6, 8, 4, 5, 2, 3}
 * Output: 604
 * Explanation: The minimum sum is formed
 * by numbers 358 and 246.
 */
public class MinSum {
    String solve(int[] arr, int n) {
        // code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        maxHeap.addAll(Arrays.stream(arr).mapToObj(Integer::valueOf).collect(java.util.stream.Collectors.toList()));
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int res = (carry + first + second) % 10;
            carry = (carry + first + second) / 10;
            sb.insert(0, res + "");
        }
        if (maxHeap.size() == 1) {
            int last = maxHeap.poll();
            sb.insert(0, ((carry + last) % 10) + "");
            carry = (carry + last) / 10;
        }
        if (carry > 0) sb.insert(0, carry + "");
        String output = sb.toString();
        int start = 0;
        for (int i = 0; i < output.length(); i++) {
            if (output.charAt(i) == '0') {
                start++;
            } else break;
        }
        return output.substring(start);
    }
}
