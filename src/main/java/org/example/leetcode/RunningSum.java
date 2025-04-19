package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RunningSum {
    public static int[] runningSum(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] + nums[i];
        }

        return output;
    }
}
