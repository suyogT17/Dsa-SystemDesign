package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
class SearchNode {
    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null) return null;
        else if (root.val == val) return root;
        else {
            if (root.val > val) return searchBST(root.left, val);
            else return searchBST(root.right, val);
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = (root.val > val) ? root.left : root.right;
        }
        return root;
    }
}