package org.example.leetcode.binarysearch;

public class Search {
    public static int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left<= right) {
            int mid = left + (right - left) / 2;

            if (target == numbers[mid]) {
                return mid;
            }

            if(target<numbers[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
