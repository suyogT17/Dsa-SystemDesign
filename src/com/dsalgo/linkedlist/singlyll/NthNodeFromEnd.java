package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
 */
class NthNodeFromEnd {
    int getNthFromLast(Node head, int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) return -1;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
}
