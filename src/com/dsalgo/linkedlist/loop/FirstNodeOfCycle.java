package com.dsalgo.linkedlist.loop;

/**
 * Problem Link: https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class FirstNodeOfCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int key) {
        val = key;
        next = null;
    }
}