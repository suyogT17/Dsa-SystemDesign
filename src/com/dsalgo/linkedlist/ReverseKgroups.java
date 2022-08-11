package com.dsalgo.linkedlist;

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

class ReverseKgroups
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
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

}

// } Driver Code Ends


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
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        Node prev = null;
        Node curr = node;
        Node head= null;
        Node end = null;
        Node start= null;
        while(curr != null){
            int i = k;
            end = start;
            start =curr;
            while(curr != null && i > 0){
                Node next = curr.next;
                curr.next =  prev;
                prev = curr;
                curr = next;
                i--;
                if(curr != null)
                    System.out.println(curr.data);
            }
            System.out.println("prev: "+prev.data);
            System.out.println(" start: "+start.data);

            if(end != null) {
                System.out.println("end: "+end.data);

                end.next = prev;
            }


            if(head == null) head = prev;
        }
        return head;
    }
}

