package org.example.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

public class CanConstructRansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i ++) {
            if(map.get(magazine.charAt(i)) == null) {
                map.put(magazine.charAt(i), 1);
            } else {
                map.merge(magazine.charAt(i), 1, Integer::sum);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0) {
                return false;
            } else {
                map.merge(ransomNote.charAt(i), -1, Integer::sum);
            }
        }

        return true;
    }
}
