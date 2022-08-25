package com.dsalgo.tree.binarysearchtree.buildbst;

import com.dsalgo.tree.binarysearchtree.TreeNode;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
 */
public class BinaryTreeToBST {
    TreeNode binaryTreeToBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        int i = 0;
        Collections.sort(inorder);
        curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr.val = inorder.get(i++);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr.val = inorder.get(i++);
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}
