package com.dsalgo.tree.binarysearchtree;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
 */
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Res {
    Node pre = null;
    Node succ = null;
}

class PreSucc {

    public static void insert(Node root, int a, int a1, char lr) {
        if (root == null) {
            return;
        }
        if (root.data == a) {
            switch (lr) {
                case 'L':
                    root.left = new Node(a1);
                    break;
                case 'R':
                    root.right = new Node(a1);
                    break;
            }
            return;
        }
        insert(root.left, a, a1, lr);
        insert(root.right, a, a1, lr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            Node root = null;
            Res p = new Res();
            Res s = new Res();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int a1 = sc.nextInt();
                char lr = sc.next().charAt(0);
                if (i == 0) {
                    root = new Node(a);
                    switch (lr) {
                        case 'L':
                            root.left = new Node(a1);
                            break;
                        case 'R':
                            root.right = new Node(a1);
                            break;
                    }
                } else {
                    insert(root, a, a1, lr);
                }
            }
            int key = sc.nextInt();
            GfG g = new GfG();
            g.findPreSuc(root, p, s, key);
            if (p.pre != null)
                System.out.print(p.pre.data + " ");
            else
                System.out.print("-1" + " ");
            if (s.succ != null)
                System.out.println(s.succ.data);
            else
                System.out.println("-1");
        }
    }
}
// } Driver Code Ends


/* BST Node
class Node
{
	int key;
	Node left, right;

	Node(int item)
	{
	    data = item;
	    left = right = null;
	}
}
*/

// This function finds predecessor and successor of key in BST.
// It sets pre and suc as predecessor and successor respectively
class GfG {
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        // add your code here
        p.pre = pre(root, key);
        s.succ = succ(root, key);
    }

    static Node pre(Node root, int key) {
        Node pred = null;
        while (root != null) {
            if (root.data < key) {
                pred = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pred;
    }

    static Node succ(Node root, int key) {
        Node succ = null;
        while (root != null) {
            if (root.data <= key) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}