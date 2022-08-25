package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
class PostOrder {
    public List<Integer> postorderTraversal(Node root) {
        List<Integer> postOrder = new LinkedList();
        if (root == null) return postOrder;
        Stack<Node> stack = new Stack();
        Node curr = root;
        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node right = stack.peek().right;
                if (right == null) {
                    right = stack.pop();
                    postOrder.add(right.data);
                    while (!stack.isEmpty() && right == stack.peek().right) {
                        postOrder.add(stack.pop().data);
                    }
                } else {
                    curr = right;
                }
            }
        }
        return postOrder;
    }
}