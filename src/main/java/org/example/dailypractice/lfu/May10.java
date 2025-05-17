package org.example.dailypractice.lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May10<K, V> {
    private int capacity;
    private int minFreq;
    private Map<K, V> cache;
    private Map<K, Integer> keyFreqMap;
    private Map<Integer, LinkedList<K>> freqKeyListMap;

    public May10(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.keyFreqMap = new HashMap<>();
        this.freqKeyListMap = new HashMap<>();
    }

    // get
    public V get(K key) {
        if(!cache.containsKey(key)){
            return null;
        }

        // get key freq
        int oldFreq = keyFreqMap.get(key);
        // get freq list
        LinkedList<K> oldList = freqKeyListMap.get(oldFreq);
        // remove key from frekeylistmap
        oldList.remove(key);

        // check minFreq
        if(oldFreq == minFreq && oldList.isEmpty()) {
            minFreq++;
        }

        // update freq
        int newFreq = oldFreq + 1;
        // add freq to keyfreqmap
        keyFreqMap.put(key, newFreq);
        // add freq to freqKeylistmap
        freqKeyListMap.computeIfAbsent(newFreq, k -> new LinkedList<>()).addLast(key);
        // get cache
        return cache.get(key);
    }

    // put
    public void put(K key, V value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            get(key);
            return;
        }

        if(capacity == cache.size()){
            LinkedList<K> leastFreqList = freqKeyListMap.get(minFreq);
            K evictKey = leastFreqList.removeFirst();
            keyFreqMap.remove(evictKey);
            cache.remove(evictKey);
        }

        keyFreqMap.put(key, 1);
        freqKeyListMap.computeIfAbsent(1, k -> new LinkedList<>()).addFirst(key);
        cache.put(key, value);
        minFreq = 1;
    }
}
