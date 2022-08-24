package com.dsalgo.linkedlist.loop;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 */
class RemoveLoop {
    public static void removeLoop(Node head) {
        Node fast = head;
        Node slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        slow = head;
        while (slow != null && fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        Node prev = slow;
        slow = slow.next;
        while (slow != null && slow != fast) {
            prev = slow;
            slow = slow.next;
        }
        if (prev != null)
            prev.next = null;
    }
}