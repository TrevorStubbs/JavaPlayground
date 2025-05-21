package org.example.leetcode.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                longest = Math.max(longest, i - left + 1);
            } else {
                while (s.charAt(left) != s.charAt(i)) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(i));
            }
        }

        return longest;
    }
}
