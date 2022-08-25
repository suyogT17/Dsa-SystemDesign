package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;
import java.util.*;
/**
 * Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
class Preorder {
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> preorder =  new LinkedList();
        if(root == null) return preorder;
        Stack<Node> stack  = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr=  stack.pop();
            preorder.add(curr.data);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null ) stack.push(curr.left);
        }

        return preorder;
    }
}