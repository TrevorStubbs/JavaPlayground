package org.example.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(map.get(c) == null) {
                map.put(c,1);
            } else {
                map.merge(c, 1, Integer::sum);
            }
        }

        for(char c: t.toCharArray()) {
            if(map.get(c) == null || map.get(c) == 0) {
                return false;
            }

            map.merge(c, -1, Integer::sum);
        }

        return true;
    }
}
