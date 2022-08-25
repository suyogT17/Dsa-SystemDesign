package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
 */
public class IsBalanceTree {
    boolean isBalanced(Node root) {
        return !(checkIfBalance(root) == -1);
    }

    int checkIfBalance(Node root) {
        if (root == null) return 0;
        int lh = checkIfBalance(root.left);
        int rh = checkIfBalance(root.right);
        if (lh == -1 || rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);
    }
}
