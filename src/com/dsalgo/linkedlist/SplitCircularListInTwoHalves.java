package com.dsalgo.linkedlist;
/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1
 */
// { Driver Code Starts

import java.util.*;

class circular_LinkedList {
    Node head, head1, head2;  // head of lisl
    Node last = null;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Function to print linked list */
    void printList(Node node) {
        Node temp = node;
        if (node != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != node);
        }
        System.out.println();
    }

    void circular() {
        last = head;
        while (last.next != null)
            last = last.next;
        last.next = head;
        //System.out.println(last);
    }


    /* Drier program to test above functions */
    public static void main(String args[]) {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            circular_LinkedList llist = new circular_LinkedList();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            llist.circular();
            //int k=sc.nextInt();
            SplitCircularListInTwoHalves g = new SplitCircularListInTwoHalves();
            //System.out.println(g.getCount(llist));
            g.splitList(llist);
            llist.printList(llist.head1);
            llist.printList(llist.head2);
            //llist.printList();
            //llist.head = llist.reverse(llist.head);
            //llist.printList();
            t--;
        }
    }
}


class SplitCircularListInTwoHalves {
    // Function  to split a circular LinkedList
    void splitList(circular_LinkedList list) {
        // Your code here
        Node curr = list.head;
        int count = 0;
        while (curr.next != list.head) {
            curr = curr.next;
            count++;
        }
        int i = 0;
        curr = list.head;
        list.head1 = curr;
        while (curr.next != list.head) {
            if (i == count / 2) {
                list.head2 = curr.next;
                curr.next = list.head1;
                curr = list.head2;
            } else curr = curr.next;
            i++;
        }
        curr.next = list.head2;
    }
}