package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
 */
class IntersectionInTwoYShapeLL
{
    //Function to find intersection point in Y shaped Linked Lists.
    int intersectPoint(Node head1, Node head2)
    {
        // code here
        int len1 =  findLength(head1);
        int len2 =  findLength(head2);
        if(len2 > len1){
            Node temp =  head1;
            head1 =  head2;
            head2 = temp;
        }
        int i=0;
        while(head1 != null &&  i< Math.abs(len1 - len2)){
            head1 =  head1.next;
            i++;
        }
        while(head1!= null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.data;
    }

    int findLength(Node head){
        int len = 0;
        while(head != null){
            head =  head.next;
            len++;
        }
        return len;
    }
}