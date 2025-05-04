package org.example.learning.caching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache<K, V> {
    private final int capacity;
    private int minFeq;
    private final Map<K, V> cache;
    private final Map<K, Integer> keyFreq;
    private final Map<Integer, LinkedList<K>> freqList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFeq = 0;
        this.cache = new HashMap<>();
        this.keyFreq = new HashMap<>();
        this.freqList = new HashMap<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        int freq = keyFreq.get(key);
        LinkedList<K> oldList = freqList.get(freq);
        oldList.remove(key);

        if (freq == minFeq && oldList.isEmpty()) {
            minFeq++;
        }

        int newFreq = freq + 1;
        keyFreq.put(key, newFreq);
        freqList.computeIfAbsent(newFreq, k -> new LinkedList<>()).addLast(key);

        return cache.get(key);
    }

    public void put(K key, V value) {
        if(capacity <= 0) {
            return;
        }

        if(cache.containsKey(key)){
            cache.put(key,value);
                    get(key); // use get to increment
        }

        if(cache.size() >= capacity) {
            LinkedList<K> leastFreqList = freqList.get(minFeq);
            K evictKey = leastFreqList.removeFirst();
            cache.remove(evictKey);
            keyFreq.remove(evictKey);
        }

        cache.put(key, value);
        keyFreq.put(key, 1);
        freqList.computeIfAbsent(1, k -> new LinkedList<>()).addLast(key);
        minFeq = 1;
    }

    @Override
    public String toString() {
        return "Cache=" + cache + ", Frequencies=" + keyFreq;
    }
}
