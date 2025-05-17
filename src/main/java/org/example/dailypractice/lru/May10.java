package org.example.dailypractice.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May10<K,V> {
    private int capacity;
    private Map<K,V> cache;
    private LinkedList<K> usageList;

    public May10(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.usageList = new LinkedList<>();
    }

    public V get(K key) {
        if(!cache.containsKey(key)){
            return null;
        }

        usageList.remove(key);
        usageList.addFirst(key);
        return cache.get(key);
    }

    public void put(K key, V value) {
        if(cache.containsKey(key)){
            usageList.remove(key);
        }

        if(cache.size()==capacity){
            K evictThis = usageList.removeLast();
            cache.remove(evictThis);
        }

        usageList.addFirst(key);
        cache.put(key, value);
    }
}
