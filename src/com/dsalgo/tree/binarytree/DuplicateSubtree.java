package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1
 */
class DuplicateSubtree {

    Map<String, Integer> map = new HashMap();

    String solve(Node root) {
        if (root == null) return "$_";
        String s = "";
        if (root.left == null && root.right == null) {
            return root.data + "";
        }
        s += root.data + "_";
        s += solve(root.left) + "_";
        s += solve(root.right) + "_";
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }

    int dupSub(Node root) {
        solve(root);
        //System.out.println(map);
        map.values().removeIf(v -> (v < 2));
        return (map.size() != 0) ? 1 : 0;
    }
}