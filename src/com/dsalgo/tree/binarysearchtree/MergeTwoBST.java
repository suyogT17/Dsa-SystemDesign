package com.dsalgo.tree.binarysearchtree;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/h_920474
 */
public class MergeTwoBST {

    static TreeNode mainHead = null;
    static TreeNode aRPrev = null;

    static TreeNode mergeBST(TreeNode root1, TreeNode root2) {
        // Write your code here.
        TreeNode backupRoot1 = root1;
        recursiveConvertTreeToDLL(root1);
        TreeNode newRoot1 = aRPrev;
        aRPrev = null;
        TreeNode backupRoot2 = root2;
        recursiveConvertTreeToDLL(root2);
        TreeNode newRoot2 = aRPrev;
        aRPrev = null;
        TreeNode head = mergeLinkedList(newRoot1, newRoot2);
        int n = length(head);
        mainHead = head;
        TreeNode output = convertDLLtoBST(n);
        //System.out.println(output.right.val);
        mainHead = null;
        return output;
    }

    static TreeNode convertDLLtoBST(int n) {
        if (n <= 0) return null;
        TreeNode left = convertDLLtoBST(n / 2);
        TreeNode root = mainHead;
        root.left = left;
        mainHead = mainHead.right;
        root.right = convertDLLtoBST(n - (n / 2) - 1);
        return root;
    }

    static TreeNode mergeLinkedList(TreeNode node1, TreeNode node2) {
        TreeNode head = null;
        TreeNode tail = null;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                if (head == null) {
                    head = node1;
                    tail = node1;
                    node1 = node1.right;
                } else {
                    tail.right = node1;
                    node1.left = tail;
                    tail = tail.right;
                    node1 = node1.right;
                }
            } else {
                if (head == null) {
                    head = node2;
                    tail = node2;
                    node2 = node2.right;
                } else {
                    tail.right = node2;
                    node2.left = tail;
                    tail = tail.right;
                    node2 = node2.right;
                }
            }
        }
        if (node1 != null) {
            tail.right = node1;
        }
        if (node2 != null) {
            tail.right = node2;
        }
       /*intDLL(head);
       System.out.println("Printing head : "+head.val);
       printDLLReverse(head);*/
        return head;
    }

    static void printDLL(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println();
    }

    static int length(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    static void printDLLReverse(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.left;
        }
        System.out.println();
    }

    static void recursiveConvertTreeToDLL(TreeNode root) {
        if (root == null) return;
        recursiveConvertTreeToDLL(root.right);
        root.right = aRPrev;
        if (aRPrev != null) aRPrev.left = root;
        aRPrev = root;
        recursiveConvertTreeToDLL(root.left);
    }
}