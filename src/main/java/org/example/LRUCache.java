package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LRUCache {
    private final Integer cacheSize;
    private final Set<Integer> itemSet;
    private final LinkedList<Integer> cache;
    private Map<Integer,Integer> map;

    public LRUCache(Integer cacheSize) {
        this.cacheSize = cacheSize;
        this.itemSet = new HashSet<>();
        this.cache = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public Boolean put(Integer number) {
        if (number == null) {
            return false;
        }

        if (itemSet.contains(number)) {
            cache.remove(number);
            cache.addFirst(number);

            return true;
        }

        itemSet.add(number);

        if (itemSet.size() > cacheSize) {
            Integer last = cache.peekLast();
            cache.removeLast();
            itemSet.remove(last);
        }

        cache.addFirst(number);

        return true;
    }

    public Optional<Integer> get(Integer number) {
        return itemSet.contains(number) ? Optional.of(number) : Optional.empty();
    }

    public LinkedList<Integer> getCache() {return this.cache;}
}
