package com.systemdesign.machinecoding.cache.algorithm.evictionpolicy;


import com.systemdesign.machinecoding.cache.exception.NoSuchNodeException;

public interface EvictionPolicy {
    void keyAccessed(String key) throws NoSuchNodeException;
    String evict() throws NoSuchNodeException;
}
