package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestInBST {
    int kthSmallest = 0;
    int gk = 0;

    public int kthSmallest(TreeNode root, int k) {
        int[] ka = new int[1];
        ka[0] = k;
        return inorder(root, ka).val;
    }

    private TreeNode inorder(TreeNode root, int[] ka) {
        if (root == null) {
            return null;
        }
        TreeNode left = inorder(root.left, ka);
        if (left != null) return left;
        if (ka[0]-- == 1) {
            return root;
        }
        return inorder(root.right, ka);
    }
}
