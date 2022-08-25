package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1
 */
public class IntersectionOfTwoLL {
    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        Node newHead = null;
        Node head = null;
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                if (newHead == null) {
                    newHead = new Node(head1.data);
                    head = newHead;
                } else {
                    newHead.next = new Node(head1.data);
                    newHead = newHead.next;
                }
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) head1 = head1.next;
            else head2 = head2.next;
        }
        return head;
    }
}
