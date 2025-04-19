package org.example.leetcode;

public class RemoveElement {
    public static int removeElement(int[] numbers, int value) {
        int count = 0; // acts as a counter and the index of the last known valid number
        for (int index = 0; index < numbers.length; index++) {
            if (numbers[index] != value) {
                numbers[count] = numbers[index];
                count++;
            }
        }
        return count;
    }

    public static int removeElementWhileLoop(int[] nums, int val) {
        int result = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] != val) {
                nums[result] = nums[right];
                result++;
            }
            right++;
        }

        return result;
    }
}
