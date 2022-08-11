package com.dsalgo.linkedlist.quicksortll;

// { Driver Code Starts
// { Driver Code Starts

import java.util.Scanner;

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

class QuickSortLL
{
    static Node head;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            addToTheLast(head);

            for(int i = 1; i< n; i++)
            {
                int a = sc.nextInt();
                addToTheLast(new Node(a));
            }

            GfG gfg = new GfG();
            Node node = gfg.quickSort(head);

            printList(node);
            System.out.println();
        }
    }
    public static void printList(Node head)
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void addToTheLast(Node node)
    {
        if (head == null)
        {
            head = node;
        } else
        {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }
}// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }

}*/
// you have to complete this function
class GfG
{
    public static Node quickSort(Node node)
    {
        //Your code here
        Node left =  node;
        Node right = node;
        while(right.next != null)
        {
            right =  right.next;
        }

        return quickSort1(left, right, null);
    }

    static Node quickSort1(Node left, Node right, Node prev){

        if(left == null || right == null || left == right )
            return null;
        printLL(left);
        Node pivot = partition(left, right, prev);
        quickSort1(left, pivot, prev);
        if(pivot != null && pivot == left)
            quickSort1(pivot.next, right, pivot);
        else if(pivot != null && pivot.next != null) quickSort1(pivot.next.next, right, pivot.next);

        return left;
    }

    static Node partition(Node left1, Node right1, Node prev){

        if(left1 == null|| right1 == null || left1 == right1) return left1;
        Node pivot = right1;
        Node curr =  left1;
        // Node prev  =  left1;
        while(curr != null && right1 != null && curr != right1){
            if(curr.data >= right1.data){
                Node pnext  =  pivot.next;
                Node cnext =  curr.next;
                pivot.next = curr;
                if(prev != null) prev.next = curr.next;

                curr.next = pnext;
                curr = cnext;
                pivot = pivot.next;
            }else {
                prev = curr;
                curr =  curr.next;
            }
        }

        return prev;

    }
    static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " -> ");
            head =  head.next;
        }
        System.out.println();
    }

}