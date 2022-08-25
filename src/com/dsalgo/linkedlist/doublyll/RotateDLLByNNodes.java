package com.dsalgo.linkedlist.doublyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/rotate-doubly-linked-list-by-p-nodes/1
 * Input: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 , P = 2
 * Output: 3 <-> 4 <-> 5 <-> 6 <-> 1 <-> 2
 * Explanation: Doubly linked list after rotating
 * 2 nodes is: 3 4 5 6 1 2.
 */
class RotateDLLByNNodes {
    public Node update(Node start, int p) {
        Node curr = start;
        int itr = 0;
        Node newHead = null;
        Node prev = null;
        while (curr != null) {
            if (itr == p) {
                newHead = curr;
                curr.prev.next = null;
                curr.prev = null;
            }
            prev = curr;
            curr = curr.next;
            itr++;
        }
        prev.next = start;
        start.prev = prev;
        return newHead;
    }
}