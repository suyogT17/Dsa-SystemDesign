package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/k-sum-paths/1
 */
class KPathSum {
    private void countPaths(Node root, int k, int count[], List<Integer> paths) {
        if (root == null) return;
        paths.add(root.data);
        countPaths(root.left, k, count, paths);
        countPaths(root.right, k, count, paths);
        int sum = 0;
        for (int i = paths.size() - 1; i >= 0; i--) {
            sum += paths.get(i);
            if (sum == k) {
                count[0]++;
            }
        }
        paths.remove(paths.size() - 1);
    }

    public int sumK(Node root, int k) {
        int count[] = new int[]{0};
        List<Integer> paths = new ArrayList();
        countPaths(root, k, count, paths);
        return count[0];
    }
}