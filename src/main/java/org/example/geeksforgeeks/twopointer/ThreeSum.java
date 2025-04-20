package org.example.geeksforgeeks.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum {
    public static boolean threeSum(int[] array, int target) {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) { // -2 since we are going to do i + 1 lookup.
            int left = i + 1;
            int right = array.length - 1;

            int requiredSum = target - array[i];

            while (left < right) {
                if (array[left] + array[right] == requiredSum) {
                    return true;
                }

                if (array[left] + array[right] < requiredSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false;
    }

    public static boolean twoSumSet(int[] array, int target) {
        for (int i = 0; i < array.length - 2; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < array.length; j++) {
                int secondElement = target - array[i] - array[j];

                if(set.contains(secondElement)) {
                    return true;
                }

                set.add(array[j]);
            }
        }

        return false;
    }
}
