package org.example.learning.caching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> keyMap;
    private final LinkedList<K> usageOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyMap = new HashMap<>();
        this.usageOrder = new LinkedList<>();
    }

    public V get(K key) {
        if (!keyMap.containsKey(key)) {
            return null;
        }

        usageOrder.remove(key);
        usageOrder.addFirst(key);
        return keyMap.get(key);
    }

    public void put(K key, V value) {
        if (keyMap.containsKey(key)) {
            usageOrder.remove(key);
        } else if (keyMap.size() == capacity) {
            K leastUsed = usageOrder.remove();
            keyMap.remove(leastUsed);
        }

        usageOrder.addFirst(key);
        keyMap.put(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (K key : usageOrder) {
            sb.append(key).append("=");
            sb.append(keyMap.get(key)).append(" ");
        }

        return sb.toString();
    }
}
