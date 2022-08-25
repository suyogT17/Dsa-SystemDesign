package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;
import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/construct-tree-1/1
 */
class TreeFromInAndPreOrder {
    public static Node buildTree(int inorder[], int preorder[], int n) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1, map);
    }


    static Node buildTree(int inorder[], int inStart, int inEnd, int preorder[], int preStart, int preEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        Node root = new Node(preorder[preStart]);
        int inRoot = map.get(root.data) - inStart;
        root.left = buildTree(inorder, inStart, map.get(root.data) - 1, preorder, preStart + 1, preStart + inRoot, map);
        root.right = buildTree(inorder, map.get(root.data) + 1, inEnd, preorder, preStart + inRoot + 1, preEnd, map);
        return root;
    }
}
