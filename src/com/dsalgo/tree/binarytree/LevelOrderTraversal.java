package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/level-order-traversal/1
 */
class LevelOrderTraversal {
    static ArrayList<Integer> levelOrder(Node node) {
        Queue<Node> queue = new LinkedList();
        ArrayList<Integer> output = new ArrayList();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            output.add(curr.data);
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return output;
    }
}