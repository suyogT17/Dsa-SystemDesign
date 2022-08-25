package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;
import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-swap-required-to-convert-binary-tree-to-binary-search-tree/0
 * Given an array A[] which represents a Complete Binary Tree i.e, if index i is the parent, index 2*i + 1 is the left child and index 2*i + 2 is the right child.
 * The task is to find the minimum number of swaps required to convert it into a Binary Search Tree.
 */
class MinimumSwapsToBTtoBST {

    private static Node createTree(int[] A) {
        Queue<Node> queue = new LinkedList();
        int n = A.length;
        Node node = new Node(A[0]);
        queue.offer(node);
        for (int i = 1; i < n; i += 2) {
            Node curr = queue.poll();
            if (A[i] != -1) {
                Node left = new Node(A[i]);
                curr.left = left;
                queue.offer(left);
            }
            if (i + 1 < n && A[i + 1] != -1) {
                Node right = new Node(A[i + 1]);
                curr.right = right;
                queue.offer(right);
            }
        }
        return node;
    }

    public static int minSwaps(int n, int[] A) {
        // code here
        List<Pair> inorder = new ArrayList();
        Node root = createTree(A);
        int id[] = new int[]{0};
        getInorder(root, inorder, id);

        /*

        for(int i=0;i<n;i++){
            inorder.add(new Pair(A[i], i));
        }*/
        Collections.sort(inorder, (o1, o2) -> o1.key - o2.key);
        int output = 0;
        for (int i = 0; i < inorder.size(); i++) {
            //System.out.println(inorder.get(i).key + " " + inorder.get(i).value);
            while (inorder.get(i).value != i) {
                swap(inorder, i, inorder.get(i).value);
                output++;
            }
        }
        return output;
    }

    private static void getInorder(Node root, List<Pair> inorder, int id[]) {
        if (root == null) return;
        getInorder(root.left, inorder, id);
        //System.out.println(root.val);
        inorder.add(new Pair(root.data, id[0]++));
        getInorder(root.right, inorder, id);
    }

    private static void swap(List<Pair> inorder, int i, int j) {
        Pair tmp = inorder.get(i);
        inorder.set(i, inorder.get(j));
        inorder.set(j, tmp);
    }
}

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}