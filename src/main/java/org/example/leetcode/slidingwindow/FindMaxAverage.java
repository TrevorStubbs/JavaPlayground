package org.example.leetcode.slidingwindow;

public class FindMaxAverage {
    public static double findMaxAverage(int[] numbers, int k) {
        int counter = 0;

        for (int i = 0; i < k; i++) {
            counter += numbers[i];
        }

        double maxAverage = (double) counter / (double) k;
        int left = 0;

        for (int i = k; i < numbers.length; i++) {
            counter = counter - numbers[left] + numbers[i];
            left++;
            double average = (double) counter / (double) k;
            maxAverage = Math.max(average, maxAverage);
        }

        return maxAverage;
    }
}
