package org.example.leetcode.hashing;

import java.util.*;

public class NumJewelsInStones {
    public static int numOfJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> counterMap = new HashMap<>();

        for (int i = 0; i < jewels.length(); i++) {
            counterMap.put(jewels.charAt(i), 0); // fill map with 0s
        }

        for (int i = 0; i < stones.length(); i++) {
            if(counterMap.get(stones.charAt(i)) != null) { // if character is in map
                // add 1 key's counter
                counterMap.merge(stones.charAt(i), 1, Integer::sum);
            }
        }

        int counter = 0;

        for (int i = 0; i < counterMap.size(); i++) {
            // fill counter
            counter += counterMap.get(jewels.charAt(i));
        }

        return counter;
    }

    public static int numOfJewelsInStonesSet(String jewels, String stones) {
        int jewelCount = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }

        for (int i = 0; i < stones.length(); i++) {
            if(set.contains(stones.charAt(i))){
                jewelCount++;
            }
        }

        return jewelCount;
    }
}


