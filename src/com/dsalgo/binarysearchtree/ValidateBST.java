package com.dsalgo.binarysearchtree;

/**
 * Problem Link: https://leetcode.com/problems/validate-binary-search-tree/
 * Approach
 * - Preorder Traversal and min-max range
 * - Time = O(N)
 * - check if root value is between min and max if not then BST is not valid
 * - similarly do it for left - by changing max to root value
 * - similarly do it for right - by changing min to root value
 */
class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}