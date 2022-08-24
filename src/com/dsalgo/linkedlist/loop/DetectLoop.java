package com.dsalgo.linkedlist.loop;


/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1
 */
public class DetectLoop {
    public static boolean detectLoop(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && slow != null && fast.next != null){
            slow =  slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;

        }
        return false;

    }
}
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}