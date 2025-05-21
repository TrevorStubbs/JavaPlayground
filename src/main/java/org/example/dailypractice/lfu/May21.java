package org.example.dailypractice.lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class May21<K, V> {
    private int capacity;
    private int minFreq = 0;
    private Map<K, V> cache;
    private Map<K, Integer> keyFreqMap;
    private Map<Integer, LinkedList<K>> freqKeyListMap;

    public May21(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.keyFreqMap = new HashMap<>();
        this.freqKeyListMap = new HashMap<>();
    }

    // get
    public V get(K key) {
        if(!cache.containsKey(key)) {
            return null;
        }

        Integer oldFreq = keyFreqMap.get(key);
        LinkedList<K> oldFreqList = freqKeyListMap.get(oldFreq);
        oldFreqList.remove(key);

        if(minFreq == oldFreq && oldFreqList.isEmpty()){
            minFreq++;
        }

        Integer newFreq = oldFreq + 1;
        keyFreqMap.put(key, newFreq);
        freqKeyListMap.computeIfAbsent(newFreq, k -> new LinkedList<>()).addFirst(key);
        return cache.get(key);
    }

    // put
    public void put(K key, V value) {
        if(cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }

        if(cache.size() == capacity) {
            K removeThis = freqKeyListMap.get(minFreq).removeLast();
            keyFreqMap.remove(removeThis);
            cache.remove(removeThis);
        }

        cache.put(key, value);
        keyFreqMap.put(key, 1);
        minFreq = 1;
        freqKeyListMap.computeIfAbsent(1, k -> new LinkedList<>()).addFirst(key);
    }
}
