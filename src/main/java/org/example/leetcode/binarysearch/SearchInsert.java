package org.example.leetcode.binarysearch;

public class SearchInsert {
    public static int searchInsert(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;

        while(low<=high){
            int mid = low + (high - low) /2;

            if(numbers[mid] == target) {
                return mid;
            }

            if(target<numbers[mid]){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
