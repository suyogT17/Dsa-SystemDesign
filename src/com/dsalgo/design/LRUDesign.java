package com.dsalgo.design;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine().trim());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.

    static class Pair{
        int key, value;
        Pair next = null;
        public Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    static Pair head =  null;
    static Pair front =  head;
    static Pair rear = head;
    static int size = 0;
    static int capacity = 0;

    LRUCache(int cap)
    {
        //code here
        capacity = cap;
    }

    public static boolean isFull(){
        return size == capacity;
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        // your code here
        //System.out.println("get Key : "+key);
        //printCache();
        System.out.println("before getting "+key);
        printLL();

        Pair curr = head;
        Pair prev = null;
        while(curr != null){
            if(curr.key == key){
                if(prev == null){
                    if(head.next == null){
                        return head.value;
                    }
                    head = head.next;
                    rear.next = curr;
                    curr.next = null;
                    rear = rear.next;
                    front  = front.next;
                    System.out.println("after getting "+key);
                    printLL();
                    System.out.println("-----------------------------------------------------------");
                    return curr.value;
                }
                else if(prev != null && curr != rear){

                    prev.next =  curr.next;
                    rear.next = curr;
                    curr.next = null;
                    rear = rear.next;
                    System.out.println("after getting "+key);
                    printLL();
                    System.out.println("-----------------------------------------------------------");
                    return curr.value;
                }
                else if(prev != null && curr == rear){
                    System.out.println("after getting "+key);
                    printLL();
                    System.out.println("-----------------------------------------------------------");
                    return curr.value;
                }
            }
            prev = curr;
            curr =  curr.next;
        }
        return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        // your code here
        System.out.println("before setting "+key+"->"+value);
        printLL();

        boolean present = false;

        Pair curr = head;
        Pair prev = null;
        while(curr != null){
            if(curr.key == key){
                present =  true;
                if(prev == null){
                    if(head.next == null){
                        head.value =  value;
                        return;
                    }
                    head = head.next;
                    curr.value =  value;
                    rear.next = curr;
                    curr.next = null;
                    rear = rear.next;
                    front =  head;
                    System.out.println("after setting "+key+"->"+value);
                    printLL();
                    System.out.println("-----------------------------------------------------------");
                    return;
                }
                else if(prev != null && curr != rear){
                    curr.value = value;
                    prev.next =  curr.next;
                    rear.next = curr;
                    curr.next = null;
                    rear = rear.next;
                    System.out.println("after setting "+key+"->"+value);
                    printLL();
                    System.out.println("-----------------------------------------------------------");
                    return;
                }
                else if(prev != null && curr == rear){

                    rear.value =  value;
                    System.out.println("after setting "+key+"->"+value);
                    printLL();
                    System.out.println("-----------------------------------------------------------");
                    return;
                }
            }
            prev = curr;
            curr =  curr.next;
        }
        if(!present){
            if(isFull()){
                head =  head.next;
                front =  head;
                size--;

            }
            Pair newNode = new Pair(key, value);

            if(head == null){
                head =  newNode;
                front = head;
                rear = newNode;
            }
            else{
                rear.next = newNode;
                rear =  rear.next;
            }
            size++;
            System.out.println("after setting "+key+"->"+value);
            printLL();
            System.out.println("-----------------------------------------------------------");
        }

    }

    static void printLL(){
        Pair curr = head;
        while(curr != null){
            System.out.print("("+curr.key+", "+curr.value+")");
            curr = curr.next;
        }
        System.out.println();
    }
}
