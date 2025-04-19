package org.example.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static int majorityElement(int[] numbers) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int number : numbers) {
            counter.merge(number, 1, Integer::sum);
        }

        return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static int majorityElementRaw(int[] numbers) {
        int count = 0;
        int candidate = 0;

        for (int number : numbers) {
            if (count == 0 ) {
                candidate = number;
            }
            count += (number == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
