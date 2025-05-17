package org.example.learning.caching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final LinkedList<K> keyUsageOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyUsageOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) { // null check fo no key in cache
            return null;
        }

        keyUsageOrder.remove(key); // remove key from list
        keyUsageOrder.addFirst(key); // add key to beginning of list
        return cache.get(key); // return value from key
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) { // if key is already here
            keyUsageOrder.remove(key); // follow get and remove the key
        } else if (cache.size() == capacity) { // if cache is at capacity
            K leastUsed = keyUsageOrder.remove(); // evict last item in list
            cache.remove(leastUsed); // remove evicted item from map
        }

        keyUsageOrder.addFirst(key); // add key to list
        cache.put(key, value); // add key and value to map
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (K key : keyUsageOrder) {
            sb.append(key).append("=");
            sb.append(cache.get(key)).append(" ");
        }

        return sb.toString();
    }
}
