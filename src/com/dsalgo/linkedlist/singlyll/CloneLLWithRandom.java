package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1
 */
public class CloneLLWithRandom {
    class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;
        }
    }

    Node copyList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node tmp = new Node(curr.data);
            Node next = curr.next;
            curr.next = tmp;
            tmp.next = next;
            curr = next;
        }
        curr = head;
        while (curr != null && curr.next != null) {
            curr.next.arb = (curr.arb != null) ? curr.arb.next : null;
            curr = curr.next.next;
        }
        curr = head;
        Node newList = head.next;
        Node newHead = head.next;
        while (curr != null && curr.next != null) {
            curr.next = curr.next.next;
            if (newList.next != null)
                newList.next = newList.next.next;
            curr = curr.next;
            newList = newList.next;
        }
        return newHead;
    }

    void printLL(Node head) {
        while (head != null) {
            System.out.print("(" + head.data + ", " + head.arb.data + ") ");
            head = head.next;
        }
        System.out.println();
    }
}