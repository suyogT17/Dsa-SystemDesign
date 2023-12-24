package com.systemdesign.machinecoding.cache.storage;

import java.util.Map;

public interface Storage {
    void add(String key, Value value);
    void remove(String key);
    boolean isFull();
    String getValue(String key);
}

