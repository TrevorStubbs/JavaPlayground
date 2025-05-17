package org.example.dailypractice.lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May06<K, V> {
    private int capacity;
    private int minFeq;
    private Map<K, V> cache;
    private Map<K, Integer> keyFreqMap;
    private Map<Integer, LinkedList<K>> freqMap;

    public May06(int capacity) {
        this.capacity = capacity;
        minFeq = 0;
        this.cache = new HashMap<>();
        this.keyFreqMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    // get
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        // remove key from keyfreqMap and from freqMap
        int oldFeq = keyFreqMap.get(key);
        LinkedList<K> oldList = freqMap.get(oldFeq);
        oldList.remove(key);

        // update minFeq if needed
        if (oldFeq == minFeq && oldList.isEmpty()) {
            minFeq++;
        }

        // update keyFreqMap and freqmap
        int newFeq = oldFeq + 1;
        keyFreqMap.put(key, newFeq);
        freqMap.computeIfAbsent(newFeq, k -> new LinkedList<>()).addLast(key);

        // return value
        return cache.get(key);
    }

    // put
    public void put(K key, V value) {
        if (capacity <= 0) {
            return;
        }

        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }

        if (cache.size() == capacity) {
            LinkedList<K> list = freqMap.get(minFeq);
            K evictThis = list.removeFirst();
            keyFreqMap.remove(evictThis);
            cache.remove(evictThis);
        }

        cache.put(key, value);
        keyFreqMap.put(key, 1);
        freqMap.computeIfAbsent(1, k -> new LinkedList<>()).addLast(key);
        minFeq = 1;
    }
}
