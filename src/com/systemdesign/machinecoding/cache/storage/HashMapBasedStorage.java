package com.systemdesign.machinecoding.cache.storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage implements Storage {

    Map<String, Value> mapping;
    int capacity;

    public HashMapBasedStorage(int capacity){
        this.mapping = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void add(String key, Value value) {
        if(!isFull()) {
            mapping.put(key, value);
        }//else throw new StorgeFullException();
    }

    @Override
    public void remove(String key) {
        if(mapping.containsKey(key)) mapping.remove(key);
        //else throw new KeyNotExistException();
    }

    @Override
    public String getValue(String key){
        if(mapping.containsKey(key)) return mapping.get(key).toString();
        else return null; //throw KeyNotExistException();
    }

    @Override
    public boolean isFull() {
        return mapping.size() == capacity;
    }
}