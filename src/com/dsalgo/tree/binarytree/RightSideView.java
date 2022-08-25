package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;
import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/binary-tree-right-side-view/
 */
class RightSideView {
    public List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList();
        rightView(root, 0, ans);
        return ans;
    }

    // using reverse preorder traversal (Root, Right , Left)
    void rightView(Node node, int level, List<Integer> ans) {
        if (node == null) return;
        if (level == ans.size()) { // check if right side view for level is present or not
            ans.add(node.data);
        }
        rightView(node.right, level + 1, ans);
        rightView(node.left, level + 1, ans);
    }
}