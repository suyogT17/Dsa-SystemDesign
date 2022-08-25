package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1
 */
class MinElement {
    // Function to find the minimum element in the given BST.
    int minValue(TreeNode TreeNode) {
        if(TreeNode == null) return -1;
        while(TreeNode.left != null){
            TreeNode = TreeNode.left;
        }
        return TreeNode.val;

    }
}