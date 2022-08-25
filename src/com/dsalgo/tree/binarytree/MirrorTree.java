package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/mirror-tree/1
 */
class MirrorTree {
    void mirror(Node node) {
        if (node.left == null && node.right == null) return;
        if (node.right == null) {
            node.right = node.left;
            node.left = null;
        } else if (node.left == null) {
            node.left = node.right;
            node.right = null;
        } else {
            Node temp = node.right;
            node.right = node.left;
            node.left = temp;
        }
        if (node.left != null) mirror(node.left);
        if (node.right != null) mirror(node.right);
    }
}