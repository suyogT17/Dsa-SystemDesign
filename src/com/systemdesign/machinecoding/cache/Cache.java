package com.systemdesign.machinecoding.cache;

import com.systemdesign.machinecoding.cache.algorithm.evictionpolicy.EvictionPolicy;
import com.systemdesign.machinecoding.cache.storage.HashMapBasedStorage;
import com.systemdesign.machinecoding.cache.storage.Pair;
import com.systemdesign.machinecoding.cache.storage.Storage;
import com.systemdesign.machinecoding.cache.storage.Value;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cache {

    Map<String, String> valToTypeMapping;
    private EvictionPolicy evictionPolicy;
    private Storage storage;

    public Cache(EvictionPolicy evictionPolicy, Storage storage){
        this.valToTypeMapping = new HashMap<>();
        this.storage = storage;
    }

    public String get(String key){
        try {
            String value = storage.getValue(key);
            evictionPolicy.keyAccessed(key);
            return value;
        } catch (Exception keyNotExistException){
            System.out.println("Key not present in cache");
            return null;
        }
    }

    List<String> search(String attributeKey, String attributeValue) {
        List<String> keys = storage.search(attributeKey, attributeValue);
        if(!keys.isEmpty()) {
            for(String key: keys) evictionPolicy.keyAccessed(key);
        }
        return keys;
    }

    boolean put(String key, List<Pair<String, Object>> listOfAttributePairs){
        Value value = new Value();
        value.parse(listOfAttributePairs);
        storage.add(key, value);
        evictionPolicy.keyAccessed(key);
    }

    void delete(String key){}

    String keys(){}

}
