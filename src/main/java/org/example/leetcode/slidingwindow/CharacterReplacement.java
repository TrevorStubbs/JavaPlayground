package org.example.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int replaceCounter = 0;
        int longest = 0;
        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            replaceCounter = Math.max(replaceCounter, map.get(s.charAt(i)));

            while ((i - left + 1) - replaceCounter > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);

                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }

                left++;
            }

            longest = Math.max(longest, i - left + 1);
        }

        return longest;
    }
}
