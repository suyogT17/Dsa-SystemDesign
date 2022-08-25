package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> output =  new ArrayList();
        if(root == null) return output;
        Boolean flag  =  false;
        Queue<Node> queue =  new LinkedList();
        queue.add(root);

        while(root != null && !queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> i =  new ArrayList();
            while(size != 0){
                Node curr = queue.poll();
                i.add(curr.data);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                size--;
            }
            if(flag == true){
                Collections.reverse(i);

            }
            output.add(i);
            flag = !flag;
        }
        return output;

    }
}