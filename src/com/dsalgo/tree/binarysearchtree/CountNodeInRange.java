package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1
 */
class CountNodeInRange {
    int getCount(Node root, int l, int h) {
        int count[] = new int[]{0};
        inorder(root, l, h, count);
        return count[0];
    }

    void inorder(Node root, int l, int h, int[] count) {
        if (root == null) {
            return;
        }
        inorder(root.left, l, h, count);
        if (root.data >= l && root.data <= h) count[0]++;
        inorder(root.right, l, h, count);
    }
}
