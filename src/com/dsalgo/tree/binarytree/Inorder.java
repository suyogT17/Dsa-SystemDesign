package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;
import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
class Inorder {
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> res = new LinkedList();
        Stack<Node> stack = new Stack();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            Node temp = stack.pop();
            res.add(temp.data);
            curr = temp.right;
        }
        return res;
    }
}