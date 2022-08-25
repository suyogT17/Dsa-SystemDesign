package com.dsalgo.tree.binarysearchtree;

import java.util.Stack;

/**
 * Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
class BSTtoLL {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        TreeNode head = null;
        flatten3(root, head);
    }


    public void flatten3(TreeNode root, TreeNode head) {
        if (root == null) return;
        flatten3(root.right, head);
        root.right = head;
        root.left = null;
        head = root;
        flatten3(root.left, head);
    }

    public void flatten4(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        root.right = prev;
        root.left = null;
        prev = root;
        flatten(root.left);
    }

    public void flatten2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
    }

    public void flatten1(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}