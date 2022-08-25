package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
 */
class LongestBloodline {
    class Pair {
        int length, value;

        public Pair(int length, int value) {
            this.length = length;
            this.value = value;
        }
    }

    int ans = 0;

    public int sumOfLongRootToLeafPath(Node root) {
        findAns(root);
        int newAns = ans;
        ans = 0;
        return newAns;
    }

    Pair findAns(Node root) {
        if (root == null) return new Pair(0, 0);
        Pair left = findAns(root.left);
        Pair right = findAns(root.right);
        Pair p = null;
        if (left.length > right.length) {
            ans = root.data + left.value;
            p = new Pair(1 + left.length, root.data + left.value);
        } else if (right.length > left.length) {
            ans = root.data + right.value;
            p = new Pair(1 + right.length, root.data + right.value);
        } else {
            ans = root.data + Math.max(right.value, left.value);
            p = new Pair(1 + right.length, root.data + Math.max(right.value, left.value));
        }
        //ans = Math.max(ans, root.data+Math.max(left,right));
        return p;
    }
}