package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 */
class BoundaryTraversal {
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> ans = new ArrayList();
        if (isLeaf(node) == false) ans.add(node.data);
        getLeftBoundary(node, ans);
        getLeaves(node, ans);
        getRightBoundary(node, ans);
        return ans;
    }

    void getLeftBoundary(Node node, ArrayList<Integer> ans) {
        Node curr = node.left;
        while (curr != null) {
            if (isLeaf(curr) == false) ans.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    void getRightBoundary(Node node, ArrayList<Integer> ans) {
        Node curr = node.right;
        ArrayList<Integer> temp = new ArrayList();
        while (curr != null) {
            if (isLeaf(curr) == false) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }

    void getLeaves(Node node, ArrayList<Integer> ans) {
        if (isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if (node.left != null) getLeaves(node.left, ans);
        if (node.right != null) getLeaves(node.right, ans);
    }

    boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
