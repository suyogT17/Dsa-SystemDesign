package com.dsalgo.arrays.matrix.binarysearchinmatrix;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
 * below mentioned sol using pe but we can implement it using binary search also
 */
class KthElementInMatrix {
    static class Node {
        int val, i, j;

        public Node(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }

    public static int kthSmallest(int[][] matrix, int n, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((obj1, obj2) -> obj1.val - obj2.val);
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Node(matrix[i][0], i, 0));
        }
        while (k > 1 && !pq.isEmpty()) {
            Node tmp = pq.poll();
            k--;
            if (tmp.j + 1 < n) {
                pq.offer(new Node(matrix[tmp.i][tmp.j + 1], tmp.i, tmp.j + 1));
            }
        }
        return (pq.isEmpty()) ? -1 : pq.poll().val;
    }
}