package org.example.dailypractice.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May05<K, V> {
    // Step 1 vars
    private final int capacity;
    private final Map<K, V> keyMap;
    private final LinkedList<K> keyUsageOrder;

    // Step 2 constructor
    public May05(int capacity) {
        this.capacity = capacity;
        this.keyMap = new HashMap<>();
        this.keyUsageOrder = new LinkedList<>();
    }

    // Step 3 get
    public V get(K key) {
        if (!keyMap.containsKey(key)) {
            return null;
        }

        keyUsageOrder.remove(key);
        keyUsageOrder.addFirst(key);
        return keyMap.get(key);
    }

    // Step 4 put
    public void put(K key, V value) {
        if (keyMap.containsKey(key)) {
            keyUsageOrder.remove(key);
        } else if (keyMap.size() == capacity) {
            K evictKey = keyUsageOrder.removeLast();
            keyMap.remove(evictKey);
        }

        keyUsageOrder.addFirst(key);
        keyMap.put(key, value);
    }
}
