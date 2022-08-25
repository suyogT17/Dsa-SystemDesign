package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 */
class LeftSideView
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList();
        rightView(root, 0, ans);
        return ans;
    }

    // using reverse preorder traversal (Root, Right , Left)
    void rightView(Node node, int level, List<Integer> ans) {
        if (node == null) return;
        if (level == ans.size()) { // check if right side view for level is present or not
            ans.add(node.data);
        }
        rightView(node.left, level + 1, ans);
        rightView(node.right, level + 1, ans);

    }
}