package com.dsalgo.tree.binarysearchtree;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
 */
public class InorderSuccessorOfAllNodes {
    class Node {
        int data;
        Node left, right, next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node next = null;

    public void populateNex1t(Node root) {
        Stack<Node> stack = new Stack();
        Node temp = root;
        while (temp.left != null) {
            stack.push(temp);
            temp = temp.left;
        }
        if (temp.right != null) {
            Node t = temp.right;
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
        }
        Node curr = temp;
        while (!stack.isEmpty()) {
            Node inorder = stack.pop();
            curr.next = inorder;
            if (inorder.right != null) {
                Node t = inorder.right;
                while (t != null) {
                    stack.push(t);
                    t = t.left;
                }
            }
            curr = inorder;
        }
    }

    public void populateNext(Node root) {
        populateNextRecur(root);
    }

    public void populateNextRecur(Node root) {
        if (root == null) return;
        populateNextRecur(root.right);
        root.next = next;
        next = root;
        populateNextRecur(root.left);
    }
}
