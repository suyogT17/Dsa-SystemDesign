package com.dsalgo.linkedlist;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 */
class RemoveDuplicatesSortedLL {
    Node removeDuplicates(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.next != null && curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else curr = curr.next;
        }
        return head;
    }
}
