package com.dsalgo.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
 * Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
 * Example 1:
 *
 * Input:
 * K = 3
 * arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
 * Output: 1 2 3 4 5 6 7 8 9
 * Explanation:Above test case has 3 sorted
 * arrays of size 3, 3, 3
 * arr[][] = [[1, 2, 3],[4, 5, 6],
 * [7, 8, 9]]
 * The merged list will be
 * [1, 2, 3, 4, 5, 6, 7, 8, 9].
 */
class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((o1, o2) -> o1.value - o2.value);
        ArrayList<Integer> output = new ArrayList();
        for (int i = 0; i < K; i++) {
            minHeap.add(new Node(arr[i][0], i, 0));
        }
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            output.add(curr.value);
            if (curr.j + 1 < K) minHeap.add(new Node(arr[curr.i][curr.j + 1], curr.i, curr.j + 1));
        }
        return output;
    }
}

class Node {
    int i, j;
    int value;

    public Node(int value, int i, int j) {
        this.value = value;
        this.i = i;
        this.j = j;
    }
}