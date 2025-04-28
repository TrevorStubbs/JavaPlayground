package org.example.geeksforgeeks.twopointer;

public class SortedSquares {
    public static int[] sortedSquares(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * numbers[i];
        }

        int[] output = new int[numbers.length];
        int left = 0;
        int right = numbers.length - 1;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[left] > numbers[right]) {
                output[i] = numbers[left];
                left++;
            } else {
                output[i] = numbers[right];
                right--;
            }
        }

        return output;
    }
}
