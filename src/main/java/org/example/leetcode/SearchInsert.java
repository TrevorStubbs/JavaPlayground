package org.example.leetcode;

public class SearchInsert {
    public static int searchInsert(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == numbers[mid]) {
                return mid;
            }

            if (target < numbers[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start; // start is where the index should be
    }
}
