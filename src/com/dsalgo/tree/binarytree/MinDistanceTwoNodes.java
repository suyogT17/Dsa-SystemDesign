package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
 */
class MinDistanceTwoNodes {
    int findDist(Node root, int a, int b) {
        Node ancestor = findAncestor(root, a, b);
        int adist = findAns(ancestor, a);
        int bdist = findAns(ancestor, b);
        //System.out.println(ancestor.data+" "+adist+" "+bdist);
        return adist + bdist - 2;
        //return output;
    }

    int findAns(Node ancestor, int a) {
        if (ancestor == null) return 0;
        if (ancestor.data == a) return 1;
        int left = findAns(ancestor.left, a);
        int right = (left == 0) ? findAns(ancestor.right, a) : 0;
        if (left == 0 && right == 0) return 0;
        return 1 + left + right;
    }

    private Node findAncestor(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b) {
            return root;
        }
        Node left = findAncestor(root.left, a, b);
        Node right = findAncestor(root.right, a, b);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }
}