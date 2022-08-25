package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/largest-bst/1
 */

class Holder {
    int size, min, max;

    public Holder(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}


class LargestBST {

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        return largestBst1(root).size;
    }

    static Holder largestBst1(Node root) {
        if (root == null) return new Holder(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Holder left = largestBst1(root.left);
        Holder right = largestBst1(root.right);
        if (root.data > left.max && root.data < right.min) {
            return new Holder(left.size + right.size + 1, Math.min(left.min, root.data), Math.max(right.max, root.data));
        } else return new Holder(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}