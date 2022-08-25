package com.dsalgo.linkedlist.doublyll;

/**
 * Problem Link:  https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
 */
class FlattenLL {
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node root) {
        if (root.next == null) {
            return root;
        }
        Node next = flatten(root.next);
        Node start = new Node(0);
        Node returnStart = start;
        while (next != null && root != null) {
            if (next.data > root.data) {
                start.bottom = root;
                root = root.bottom;
            } else {
                start.bottom = next;
                next = next.bottom;
            }
            start = start.bottom;
        }
        while (next != null) {
            start.bottom = next;
            next = next.bottom;
            start = start.bottom;
        }
        while (root != null) {
            start.bottom = root;
            root = root.bottom;
            start = start.bottom;
        }
        returnStart.next = null;
        return returnStart.bottom;
    }
}

