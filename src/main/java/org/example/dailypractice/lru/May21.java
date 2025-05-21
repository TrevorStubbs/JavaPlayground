package org.example.dailypractice.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May21<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private LinkedList<K> usageOrder;

    public May21(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.usageOrder = new LinkedList<>();
    }

    // get
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        usageOrder.remove(key);
        usageOrder.addFirst(key);
        return cache.get(key);
    }

    // put
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            usageOrder.remove(key);
        }

        if (cache.size() == capacity) {
            K removeThis = usageOrder.removeLast();
            cache.remove(removeThis);
        }

        usageOrder.addFirst(key);
        cache.put(key, value);
    }
}
