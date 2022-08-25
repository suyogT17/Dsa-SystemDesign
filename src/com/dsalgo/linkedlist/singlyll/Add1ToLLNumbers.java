package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1
 */
public class Add1ToLLNumbers {
    public static Node addOne(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = prev;
        Node oldPrev = prev;
        int carry = 1;
        prev = null;
        while (curr != null) {
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            prev = curr;
            curr = curr.next;
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            prev.next = newNode;
            prev = prev.next;
        }
        curr = oldPrev;
        prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + "  ");
            head = head.next;
        }
        System.out.println();
    }
}
