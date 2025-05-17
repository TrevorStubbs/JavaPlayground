package org.example.dailypractice.lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May07<K, V> {
    private int capacity;
    private int minFreq;
    private Map<K, V> cache;
    private Map<K, Integer> keyFreqMap;
    private Map<Integer, LinkedList<K>> freqList;

    public May07(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        cache = new HashMap<>();
        keyFreqMap = new HashMap<>();
        freqList = new HashMap<>();
    }

    // get
    public V get(K key) {
        // no key
        if (!cache.containsKey(key)) {
            return null;
        }

        // remove key from freq list
        int oldFreq = keyFreqMap.get(key);
        LinkedList<K> oldList = freqList.get(oldFreq);
        oldList.remove(key);

        // check minFreq
        if (minFreq == oldFreq && oldList.isEmpty()) {
            minFreq++;
        }

        // increment key's freq
        int newFreq = oldFreq + 1;
        // add that freq to keyFreqMap
        keyFreqMap.put(key, newFreq);
        // add that freq to freqMap
        freqList.computeIfAbsent(newFreq, k -> new LinkedList<>()).addFirst(key);

        // return cache get
        return cache.get(key);
    }


    // put
    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }

        // if full evict
        if (cache.size() == capacity) {
            LinkedList<K> minList = freqList.get(minFreq);
            K removeThisKey = minList.removeLast();
            keyFreqMap.remove(removeThisKey);
            cache.remove(removeThisKey);
        }

        // update
        cache.put(key, value);
        keyFreqMap.put(key, 1);
        freqList.computeIfAbsent(1, k -> new LinkedList<>()).addFirst(key);
        minFreq = 1;
    }
}
