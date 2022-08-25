package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1
 */
class DeleteNodeGTX {
    Node compute(Node head) {
        while (!righOrder(head)) {
            Node curr = head;
            Node prev = null;
            while (curr.next != null) {
                if (curr.data < curr.next.data) {
                    if (curr == head) {
                        head = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    boolean righOrder(Node curr) {
        while (curr.next != null) {
            if (curr.data < curr.next.data) return false;
            curr = curr.next;
        }
        return true;
    }
}
