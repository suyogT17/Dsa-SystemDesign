package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
 */
class DiameterOfTree {
    int max = 0;

    public int diameterOfBinaryTree(Node root) {
        find(root);
        return max;
    }

    int find(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = find(root.left);
        int rh = find(root.right);
        max = Math.max(max, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}