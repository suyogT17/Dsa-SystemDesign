package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
 */
public class LeafAtSameLevel {
    boolean check(Node root) {
        return checkLevel(root) != -1;
    }

    int checkLevel(Node root) {
        if (root == null) return 0;
        int left = checkLevel(root.left);
        int right = checkLevel(root.right);
        if (left == -1 || right == -1) return -1;
        if ((left != 0 && right != 0) && left != right) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
