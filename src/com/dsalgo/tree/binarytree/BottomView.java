package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 */
class BottomView {
    class Pair {
        Node node;
        int hd;

        public Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList();
        if (root == null) return ans;
        Queue<Pair> queue = new ArrayDeque<>();
        TreeMap<Integer, Integer> map = new TreeMap();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            map.put(curr.hd, curr.node.data);
            if (curr.node.left != null) queue.offer(new Pair(curr.node.left, curr.hd - 1));
            if (curr.node.right != null) queue.offer(new Pair(curr.node.right, curr.hd + 1));
        }
        for (Integer i : map.values()) {
            ans.add(i);
        }
        return ans;
    }
}