package com.dsalgo.queue;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/sum-of-minimum-and-maximum-elements-of-all-subarrays-of-size-k_1171047
 * 1
 * 5 3
 * 1 2 3 4 5
 * Sample Output 1 :
 * 18
 * Explanation For Sample Input 1 :
 * For the subarray starting from the 0th index and ending at the 2nd index, its minimum element is 1 and the maximum element is 3.
 * Similarly, for the next subarray starting at the 1st index and ending at the 3rd index, the minimum value is 2 and the maximum is 4.
 * And, for the last subarray, the minimum value is 3 and the maximum is 5. So, the total sum will be 1 + 3 + 2 + 4 + 3 + 5 = 18.
 */
class Node {
    int value, index;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class SumOfMaxMinOfArray {

    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        long sum = 0;
        PriorityQueue<Node> min = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.value, o2.value));
        PriorityQueue<Node> max = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o2.value, o1.value));
        for (int i = 0; i < k; i++) {
            min.add(new Node(nums.get(i), i));
            max.add(new Node(nums.get(i), i));
        }
        int i = 1, j = k;
        for (i = 1, j = k; j < n; i++, j++) {
            sum += min.peek().value + max.peek().value;
            while (!min.isEmpty() && min.peek().index < i) min.poll();
            while (!max.isEmpty() && max.peek().index < i) max.poll();
            min.add(new Node(nums.get(j), j));
            max.add(new Node(nums.get(j), j));
        }
        while (!min.isEmpty() && min.peek().index < i - 1) min.poll();
        while (!max.isEmpty() && max.peek().index < i - 1) max.poll();
        sum += min.peek().value + max.peek().value;
        return sum;
    }
}