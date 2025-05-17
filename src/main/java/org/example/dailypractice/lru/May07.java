package org.example.dailypractice.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May07<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private LinkedList<K> usageOrder;

    public May07(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        usageOrder = new LinkedList<>();
    }

    //get
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        usageOrder.remove(key);
        usageOrder.addFirst(key);

        return cache.get(key);
    }

    //put
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            usageOrder.remove(key);
        } else if (cache.size() == capacity) {
            K evictThis = usageOrder.removeLast();
            cache.remove(evictThis);
        }

        usageOrder.addFirst(key);
        cache.put(key, value);
    }
}
