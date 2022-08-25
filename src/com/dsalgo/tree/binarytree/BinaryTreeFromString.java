package com.dsalgo.tree.binarytree;

import com.dsalgo.tree.Node;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/0
 */
class BinaryTreeFromString {
    static int i = 0;

    public static Node treeFromString(String s) {
        int i[] = new int[]{0};
        return treeFromString(s, i);
    }

    public static Node treeFromString(String s, int i[]) {
        if (i[0] >= s.length() || s.charAt(i[0]) == ')') {
            return null;
        }
        Node root = null;
        if (s.charAt(i[0]) == '(') {
            i[0]++;
            String num = "";
            while (i[0] < s.length() && Character.isDigit(s.charAt(i[0]))) {
                num += s.charAt(i[0]++);
            }
            root = new Node(Integer.parseInt(num));
        } else {
            String num = "";
            while (i[0] < s.length() && Character.isDigit(s.charAt(i[0]))) {
                num += s.charAt(i[0]++);
            }
            root = new Node(Integer.parseInt(num));
        }
        root.left = treeFromString(s, i);
        root.right = treeFromString(s, i);
        i[0]++;
        return root;
    }
}