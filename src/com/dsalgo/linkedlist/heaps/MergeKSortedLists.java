package com.dsalgo.linkedlist.heaps;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((obj1, obj2) -> obj1.val - obj2.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                pq.add(lists[i]);
        }
        ListNode start = new ListNode(0);
        ListNode head = start;
        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            start.next = temp;
            start = start.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}