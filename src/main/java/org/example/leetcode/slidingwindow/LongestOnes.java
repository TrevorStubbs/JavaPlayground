package org.example.leetcode.slidingwindow;

public class LongestOnes {
    public static int longestOnes(int[] numbers, int k) {
        int max = 0;
        int zeroCounter = 0;
        int left = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                zeroCounter++;
            }

            while(zeroCounter > k) {
                if(numbers[left] == 0) {
                    zeroCounter--;
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
