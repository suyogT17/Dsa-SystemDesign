package com.dsalgo.tree.binarysearchtree;

import java.util.Stack;

/**
 * Problem Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
class BstIterator {
    Stack<TreeNode> stack = new Stack();
    boolean isReverse = false;

    public BstIterator(TreeNode root, boolean isReverse) {
        this.isReverse = isReverse;
        pushAll(root);
    }

    int next() {
        TreeNode ans = stack.pop();
        if (isReverse) pushAll(ans.left);
        else pushAll(ans.right);
        return ans.val;
    }

    void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            if (isReverse) root = root.right;
            else root = root.left;
        }
    }
}

class CountPairSumX {

    public boolean findTarget(TreeNode root, int k) {
        BstIterator l = new BstIterator(root, false);
        BstIterator r = new BstIterator(root, true);
        int i = l.next();
        int j = r.next();
        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }
}