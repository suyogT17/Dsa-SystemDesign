package com.dsalgo.linkedlist.singlyll;

import java.util.*;
/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
 */
public class RemoveDuplicatesUnsortedLL {
    public Node removeDuplicates(Node head) {
        Set<Integer> set = new HashSet();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (set.contains(curr.data) && prev.next != null) {
                prev.next = prev.next.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}
