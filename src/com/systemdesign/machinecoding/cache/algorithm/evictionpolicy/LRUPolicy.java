package com.systemdesign.machinecoding.cache.algorithm.evictionpolicy;

import com.systemdesign.machinecoding.cache.algorithm.DoublyLinkedList;
import com.systemdesign.machinecoding.cache.algorithm.DoublyLinkedListNode;
import com.systemdesign.machinecoding.cache.exception.NoSuchNodeException;
import com.systemdesign.machinecoding.cache.storage.Value;

import java.util.HashMap;
import java.util.Map;

public class LRUPolicy implements EvictionPolicy {

    private DoublyLinkedList doublyLinkedList;
    private Map<String, DoublyLinkedListNode> mapping;

    public LRUPolicy(){
        this.mapping = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList();
    }

    @Override
    public void keyAccessed(String key) throws NoSuchNodeException {
        if(mapping.containsKey(key)){
            DoublyLinkedListNode node = mapping.get(key);
            doublyLinkedList.removeNode(node);
            doublyLinkedList.addFirst(node);
        }
        else {
            DoublyLinkedListNode node = new DoublyLinkedListNode(key);
            doublyLinkedList.addFirst(node);
            mapping.put(key, node);
        }
    }

    @Override
    public String evict() throws NoSuchNodeException {
        DoublyLinkedListNode doublyLinkedListNode = doublyLinkedList.getLast();
        if(doublyLinkedListNode != null) {
            doublyLinkedList.removeNode(doublyLinkedListNode);
            return doublyLinkedListNode.getKey();
        }
        return null;
    }
}
