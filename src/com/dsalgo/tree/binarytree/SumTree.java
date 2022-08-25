package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
 */
public class SumTree {
    public void toSumTree(Node root) {
        createToSumTree(root);
    }

    int createToSumTree(Node root) {
        if (root.left == null && root.right == null) {
            int ans = root.data;
            root.data = 0;
            return ans;
        }
        int left = (root.left != null) ? createToSumTree(root.left) : 0;
        int right = (root.right != null) ? createToSumTree(root.right) : 0;
        int toRoot = left + right + root.data;
        root.data = left + right;
        return toRoot;
    }
}
