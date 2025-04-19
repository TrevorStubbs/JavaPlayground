package org.example.learning;

import java.util.ArrayList;
import java.util.List;

public class SubArrays {
    public static List<List<Integer>> bruteForce(int[] numbers) { // this is n^2
        List<List<Integer>> output = new ArrayList<>();
        for (int start = 0; start < numbers.length; start++) {
            for (int end = start; end < numbers.length; end++) {
                List<Integer> holder = new ArrayList<>();
                for (int index = start; index <= end; index++) {
                    holder.add(numbers[index]);
                }

                output.add(holder);
            }
        }

        return output;
    }

    // Sliding window
    public static List<List<Integer>> allSubArrays(int[] numbers) {
        List<List<Integer>> output = new ArrayList<>();

        for (int start = 0; start < numbers.length; start++) {
            List<Integer> window = new ArrayList<>();
            for (int end = start; end < numbers.length; end++) {
                window.add(numbers[end]);
                output.add(new ArrayList<>(window));
            }
        }
        return output;
    }

    public static int sumOfSizeK(int[] array, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += array[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < array.length; i++) {
            windowSum += array[i] - array[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    // Same as above with notes
    public static int sumOfK(int[] array, int windowSize) {
        int currentSum = 0;

        for (int i = 0; i < windowSize; i++) {
            currentSum += array[i]; // get the initial sum of window
        }

        int resultSum = currentSum; // set initial result

        // slide the window
        for (int i = windowSize; i<array.length; i++) {
            currentSum = currentSum + array[i]; // <-- add right
            currentSum = currentSum - array[i - windowSize]; // <-- subtract left
            currentSum += array[i] - array[i - windowSize]; // <-- both in 1 call
            resultSum = Math.max(currentSum, resultSum);
        }

        return resultSum;
    }
}
