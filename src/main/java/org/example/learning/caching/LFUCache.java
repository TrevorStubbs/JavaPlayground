package org.example.learning.caching;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache<K, V> {
    private final int capacity;
    private int minFeq;
    private final Map<K, V> cache;
    private final Map<K, Integer> keyFreqMap;
    // This is like the LRU keyUsageOrder. Ordering same usage by recently used
    private final Map<Integer, LinkedList<K>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFeq = 0;
        this.cache = new HashMap<>();
        this.keyFreqMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public V get(K key) {
        if (!cache.containsKey(key)) { // null check for no key in cache
            return null;
        }

        // get old freq
        int oldFreq = keyFreqMap.get(key); // get this key's usage frequency
        LinkedList<K> listForOldFreq = freqMap.get(oldFreq); // get the list of keys for specified frequency
        listForOldFreq.remove(key); // remove the old key from the linked list

        // update minFeq if needed
        if (oldFreq == minFeq && listForOldFreq.isEmpty()) { // if frequency is equal to minFeq and the old list in empty
            minFeq++; // increment minimumFrequency
            // this works cause minFeq is going to follow this key
        }

        // update frequency map
        int newFreq = oldFreq + 1; // increment found frequency
        keyFreqMap.put(key, newFreq); // put the key and its frequency into the keyFreqMap
        // if the new frequency is absent from freqMap create a new linked list and add the key to the frequency's list
        freqMap.computeIfAbsent(newFreq, k -> new LinkedList<>()).addLast(key); // last is most recently used

        return cache.get(key); // and finally get the item from the cache
    }

    public void put(K key, V value) {
        if (capacity <= 0) { // check for empty capacity
            return;
        }

        // update cache and increment frequency
        if (cache.containsKey(key)) {
            cache.put(key, value); // overwrite value for key with new value
            get(key); // use get() to increment key frequency
            return;
        }

        // Evict least frequently used
        if (cache.size() >= capacity) { // capacity check
            LinkedList<K> leastFreqList = freqMap.get(minFeq); // get the list of the minFeq
            K evictKey = leastFreqList.removeFirst(); // first is least recently used
            cache.remove(evictKey); // remove the key,value from cache
            keyFreqMap.remove(evictKey); // remove the key from the key frequency map
        }

        cache.put(key, value); // add key, value to cache
        keyFreqMap.put(key, 1); // add key and frequency of 1 to key freq map
        freqMap.computeIfAbsent(1, k -> new LinkedList<>()).addLast(key); // upsert key's freqMap
        minFeq = 1; // set minFreq to 1 since this new key's freq starts at 1
    }

    @Override
    public String toString() {
        return "Cache=" + cache + ", Frequencies=" + keyFreqMap;
    }
}
