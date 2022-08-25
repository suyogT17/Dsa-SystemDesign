package com.dsalgo.tree.binarysearchtree.buildbst;

import com.dsalgo.tree.binarysearchtree.TreeNode;

/**
 * Problem Link: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class BuildBstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) return null;
        TreeNode root = new TreeNode(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }
}
