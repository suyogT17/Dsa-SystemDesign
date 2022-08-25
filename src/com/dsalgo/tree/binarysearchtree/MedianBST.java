package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/median-of-bst/1
 */
class MedianBST {
    public static float findMedian(Node root) {
        int count = (int) countMorrisCount(root, true, 0);
        float ans = countMorrisCount(root, false, count);
        return ans;
    }

    static float countMorrisCount(Node root, boolean isCount, int nodesCount) {
        int count = 0;
        float node1 = 0.0f, node2 = 0.0f;
        if (root == null) return 0;
        while (root != null) {
            if (root.left == null) {
                count++;
                if (count == nodesCount / 2) {
                    node1 = (float) root.data;
                }
                if (count == (nodesCount / 2 + 1)) {
                    node2 = (float) root.data;
                }
                root = root.right;
            } else {
                Node prev = root.left;
                while (prev.right != null && prev.right != root) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    root = root.left;
                }
                if (prev.right == root) {
                    prev.right = null;
                    count++;
                    if (count == nodesCount / 2) {
                        node1 = (float) root.data;
                    }
                    if (count == (nodesCount / 2 + 1)) {
                        node2 = (float) root.data;
                    }
                    root = root.right;
                }
            }
        }
        return (isCount) ? count : (nodesCount % 2 != 0) ? node2 : (node1 + node2) / 2;
    }
}