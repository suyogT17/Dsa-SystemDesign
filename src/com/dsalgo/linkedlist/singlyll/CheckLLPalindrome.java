package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1
 */
public class CheckLLPalindrome {
    boolean isPalindrome(Node head) {
        //Your code here
        Node mid = findMid(head);
        Node revNode = reverse(mid);
        //mid.next =  revNode;
        Node curr = head;
        while (curr != null && revNode != null) {
            if (curr.data != revNode.data) return false;
            curr = curr.next;
            revNode = revNode.next;
        }
        return true;
    }

    Node findMid(Node head) {
        Node fast = head;
        Node slow = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node reverse(Node curr) {
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
