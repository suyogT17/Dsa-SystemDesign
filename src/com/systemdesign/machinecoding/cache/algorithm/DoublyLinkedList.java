package com.systemdesign.machinecoding.cache.algorithm;

import com.systemdesign.machinecoding.cache.exception.NoSuchNodeException;
import com.systemdesign.machinecoding.cache.storage.Value;

public class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public DoublyLinkedList(){
        this.head =  new DoublyLinkedListNode( null);
        this.tail = new DoublyLinkedListNode( null);
        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(DoublyLinkedListNode doublyLinkedListNode) throws NoSuchNodeException {
        if(isEmpty()) throw new NoSuchNodeException();
        DoublyLinkedListNode prev = doublyLinkedListNode.prev;
        prev.next = doublyLinkedListNode.next;
        doublyLinkedListNode.prev = prev;
    }

    public void addFirst(DoublyLinkedListNode node){
        DoublyLinkedListNode next = head.next;

        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    public DoublyLinkedListNode getLast(){
        if(!isEmpty()) return tail.prev;
        return null;
    }


    private boolean isEmpty(){
        return head.next == tail && tail.prev == head;
    }
}
