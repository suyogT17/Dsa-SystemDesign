package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;
import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1
 */
class Diagonal {
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> output = new ArrayList();
        if (root == null) return output;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            while (curr != null) {
                output.add(curr.data);
                if (curr.left != null) queue.add(curr.left);
                curr = curr.right;
            }
        }
        return output;
    }
}