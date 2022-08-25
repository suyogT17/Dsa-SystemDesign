package com.dsalgo.linkedlist.doublyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1
 */
public class ReverseDLL {
    public static Node reverseDLL(Node head) {
        //Your code here
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }
}

class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
