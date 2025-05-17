package org.example.dailypractice.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May06<K, V> {
    private int capacity;
    private Map<K, V> cache;
    private LinkedList<K> keyList;

    public May06(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyList = new LinkedList<>();
    }

    // get
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        keyList.remove(key);
        keyList.addFirst(key);
        return cache.get(key);
    }

    // put
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            keyList.remove(key);
        } else if (cache.size() == capacity) {
            K last = keyList.removeLast();
            cache.remove(last);
        }

        keyList.addFirst(key);
        cache.put(key, value);
    }
}
