package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 */
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseLLGroupOfK {
    public static Node reverse(Node node, int k) {
        Node prev = null;
        Node curr = node;
        Node head = null;
        Node end = null;
        Node start = null;
        while (curr != null) {
            int i = k;
            end = start;
            start = curr;
            while (curr != null && i > 0) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i--;
            }
            if (end != null) {
                end.next = prev;
            }
            start.next = curr;
            if (head == null) head = prev;
        }
        return head;
    }
}
