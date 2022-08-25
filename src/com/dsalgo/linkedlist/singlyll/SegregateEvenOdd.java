package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
 */
class SegregateEvenOdd {
    Node divide(int N, Node head) {
        Node even = new Node(-10);
        Node evenS = even;
        Node odd = new Node(-20);
        Node oddS = odd;
        while (head != null) {
            if (head.data % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }
        even.next = oddS.next;
        odd.next = null;
        return evenS.next;
    }
}