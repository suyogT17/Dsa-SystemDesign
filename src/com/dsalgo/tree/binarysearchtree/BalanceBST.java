package com.dsalgo.tree.binarysearchtree;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/balance-a-binary-search-tree/
 */
public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorder = new LinkedList();
        inorder(root, inorder);
        return createBst(inorder, 0, inorder.size() - 1);
    }

    TreeNode createBst(List<TreeNode> inorder, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = inorder.get(mid);
        root.left = createBst(inorder, start, mid - 1);
        root.right = createBst(inorder, mid + 1, end);
        return root;
    }

    void inorder(TreeNode root, List<TreeNode> inorder) {
        if (root == null) return;
        inorder(root.left, inorder);
        inorder.add(root);
        inorder(root.right, inorder);
    }
}
