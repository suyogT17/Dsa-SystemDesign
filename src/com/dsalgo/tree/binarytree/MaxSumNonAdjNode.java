package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1
 */

class Pair1 {
    int include, exclude;

    public Pair1(int include, int exclude) {
        this.include = include;
        this.exclude = exclude;
    }
}

class MaxSumNonAdjNode {
    static int getMaxSum(Node root) {
        Pair1 ans = helper(root);
        return Math.max(ans.include, ans.exclude);
    }

    static Pair1 helper(Node root) {
        if (root == null) return new Pair1(0, 0);
        Pair1 left = helper(root.left);
        Pair1 right = helper(root.right);
        return new Pair1(root.data + left.exclude + right.exclude, Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude));
    }
}