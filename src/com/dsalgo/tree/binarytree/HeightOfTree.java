package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
 */
class HeightOfTree {
    int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}