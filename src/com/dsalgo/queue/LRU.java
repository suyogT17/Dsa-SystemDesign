package com.dsalgo.queue;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/lru-cache/submissions/
 */
class LRU {

    class Node{
        int key, value;
        Node next = null;
        Node prev =  null;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> cache =  new HashMap();
    int capacity = 0;


    public LRU(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public boolean isFull(){
        return cache.size() == capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node newNode = new Node(key, cache.get(key).value);
            removeNode(cache.get(key));
            insertAtStart(newNode);
            return cache.get(key).value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            removeNode(cache.get(key));
            Node newNode =  new Node(key, value);
            insertAtStart(newNode);
        }
        else{
            if(isFull()){
                removeAtEnd();
            }
            Node newNode =  new Node(key, value);
            insertAtStart(newNode);
        }
    }

    void removeNode(Node node){
        Node prev =  node.prev;
        prev.next = node.next;
        node.next.prev = prev;
        cache.remove(node.key);
    }

    void removeAtEnd(){
        Node prev = tail.prev;
        prev.prev.next = tail;
        tail.prev = prev.prev;
        cache.remove(prev.key);
    }

    void insertAtStart(Node node){
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        cache.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */