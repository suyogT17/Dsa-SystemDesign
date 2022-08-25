package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/largest-sub-tree-sum_920400
 */
public class LargestSubtreeSum {
    static int ans = Integer.MIN_VALUE;

    public static int largestSubtreeSum(Node root) {
        findSum(root);
        int backup = ans;
        ans = Integer.MIN_VALUE;
        return backup;
    }

    static int findSum(Node root) {
        if (root == null) return 0;
        int left = findSum(root.left);
        int right = findSum(root.right);
        ans = Math.max(ans, root.data + left + right);
        return root.data + left + right;
    }
}