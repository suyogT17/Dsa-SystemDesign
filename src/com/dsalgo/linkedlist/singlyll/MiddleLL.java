package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://leetcode.com/problems/middle-of-the-linked-list/
 */
class MiddleLL {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}