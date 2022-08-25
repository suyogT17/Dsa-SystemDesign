package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
 */
public class BinaryTreeToDLL {
    Node prev = null;

    Node bToDLL(Node root) {
        createDLL(root);
        return prev;
    }

    void createDLL(Node root) {
        if (root == null) return;
        createDLL(root.right);
        root.right = prev;
        if (prev != null) prev.left = root;
        prev = root;
        createDLL(root.left);
    }
}
