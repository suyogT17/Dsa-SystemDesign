package com.systemdesign.machinecoding.cache.algorithm;

import com.systemdesign.machinecoding.cache.storage.Value;

public class DoublyLinkedListNode {
    private String key;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
