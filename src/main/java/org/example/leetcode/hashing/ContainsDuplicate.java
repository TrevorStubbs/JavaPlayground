package org.example.leetcode.hashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num: nums){
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }

        return false;
    }

}
