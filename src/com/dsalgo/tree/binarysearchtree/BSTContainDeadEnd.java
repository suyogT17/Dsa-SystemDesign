package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1
 */
public class BSTContainDeadEnd {
    public static boolean isDeadEnd(Node root) {
        //Add your code here.
        return isDeadEnd(root, 0, Integer.MAX_VALUE);
    }

    public static boolean isDeadEnd(Node root, int left, int right) {
        if (root == null) return false;
        if (root.data - left == 1 && right - root.data == 1) return true;
        if (isDeadEnd(root.left, left, root.data) || isDeadEnd(root.right, root.data, right)) {
            return true;
        }
        return false;
    }
}
