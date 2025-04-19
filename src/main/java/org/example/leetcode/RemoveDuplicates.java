package org.example.leetcode;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] numbers) {
        int leftIndex = 0;
        int rightIndex = 1;
        int total = 0;

        while (leftIndex < numbers.length && rightIndex < numbers.length) {
            if (numbers[leftIndex] == numbers[rightIndex]) {
                rightIndex++;
            } else {
                total++;
                leftIndex++;
                numbers[leftIndex] = numbers[rightIndex];
            }
        }

        return total;
    }
}
