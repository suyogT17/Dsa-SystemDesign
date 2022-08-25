package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://leetcode.com/problems/delete-node-in-a-bst/
 */
class DeletionNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) return helper(root);
        TreeNode backupRoot = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else root = root.left;
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else root = root.right;
            }
        }
        return backupRoot;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        else {
            TreeNode rightElem = root.right; // getting right of deleted element
            //getting extream right of left subtree of deleted element
            TreeNode extreamRightOfLeft = findExtreamRightOfLeft(root.left);
            extreamRightOfLeft.right = rightElem;
            return root.left;
        }
    }

    public TreeNode findExtreamRightOfLeft(TreeNode root) {
        if (root.right == null) return root;
        return findExtreamRightOfLeft(root.right);
    }
}