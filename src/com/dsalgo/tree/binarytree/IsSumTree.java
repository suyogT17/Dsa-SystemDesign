package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/sum-tree/1
 */
class IsSumTree {
    boolean isSumTree(Node root) {
        return verifySumTree(root) != -1;
    }

    int verifySumTree(Node root) {
        if (root == null) return 0;
        int left = verifySumTree(root.left);
        int right = verifySumTree(root.right);
        if (left == 0 && right == 0) return root.data;
        if (left == -1 || right == -1) return -1;
        if (root.data == left + right) return root.data + left + right;
        return -1;
    }
}
