package com.dsalgo.tree.binarysearchtree.buildbst;

import com.dsalgo.tree.binarysearchtree.TreeNode;

public class PreorderToBST {
    public static TreeNode post_order(int pre[], int size) {
        //Your code here
        int i[] = new int[]{0};
        TreeNode output = buildTree(pre, Integer.MAX_VALUE, i); //side true= left, false=right
        return output;
    }

    public static TreeNode buildTree(int pre[], int max, int i[]) //side true= left, false=right
    {
        if (i[0] >= pre.length) return null;
        if (pre[i[0]] > max) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[i[0]++]);
        treeNode.left = buildTree(pre, treeNode.val, i);
        treeNode.right = buildTree(pre, max, i);
        return treeNode;
    }
}
    