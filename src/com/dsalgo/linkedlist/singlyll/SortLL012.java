package com.dsalgo.linkedlist.singlyll;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
 */
class SortLL012
{
    static Node segregate(Node head)
    {
        int zeros= 0;
        int ones= 0;
        int twos = 0;
        Node curr = head;
        while(curr != null){
            switch(curr.data){
                case 0:
                    zeros++;
                    break;
                case 1:
                    ones++;
                    break;
                case 2:
                    twos++;
                    break;
            }
            curr = curr.next;
        }
        curr = head;
        while(curr !=null){
            if(zeros > 0){
                curr.data = 0;
                zeros--;
            }
            else if(ones > 0){
                curr.data = 1;
                ones--;
            }
            else{
                curr.data = 2;
                twos--;
            }
            curr =  curr.next;
        }
        return head;
    }
}
