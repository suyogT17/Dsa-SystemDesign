package com.dsalgo.heaps;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1
 */
class BinaryTreeIsHeap {

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    boolean isHeap(Node tree) {
        // code here
        Queue<Node> queue = new LinkedList();
        queue.offer(tree);
        while (!queue.isEmpty() && queue.peek() != null) {
            Node curr = queue.poll();
            queue.offer(curr.left);
            if (curr.left != null) {
                if (curr.left.data > curr.data) return false;
            }
            queue.offer(curr.right);
            if (curr.right != null) {
                if (curr.right.data > curr.data) return false;
            }
        }
        while (!queue.isEmpty() && queue.peek() == null) queue.poll();
        return queue.isEmpty() && true;
    }
}