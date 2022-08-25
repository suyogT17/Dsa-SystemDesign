package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/kth-ancestor-in-a-tree/1
 */
class KthAncestor {
    public int kthAncestor(Node root, int k, int node) {
        int[] i = new int[]{k};
        Node ans = findKth(root, i, node);
        return (ans == null || ans.data == node) ? -1 : ans.data;
    }

    Node findKth(Node root, int[] i, int node) {
        if (root == null || root.data == node) return root;
        Node left = findKth(root.left, i, node);
        Node right = findKth(root.right, i, node);
        if (left == null && right != null) {
            i[0]--;
            if (i[0] <= 0) {
                i[0] = Integer.MAX_VALUE;
                return root;
            }
            return right;
        } else if (right == null && left != null) {
            i[0]--;
            if (i[0] <= 0) {
                i[0] = Integer.MAX_VALUE;
                return root;
            }
            return left;
        }
        return null;
    }
}