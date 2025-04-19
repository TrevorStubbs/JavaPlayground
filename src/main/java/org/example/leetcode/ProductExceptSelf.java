package org.example.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] numbers) {
        int[] result = new int[numbers.length];

        Arrays.fill(result, 1);

        int prefix = 1;
        for (int i = 0; i < numbers.length; i++) {
            result[i] *= prefix;
            prefix = prefix * numbers[i];
        }

        int suffix = 1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= numbers[i];
        }

        return result;
    }

    public static int[] productExceptSelfStoredInSeparateArrays(int[] numbers) {
        int[] prefixArray = new int[numbers.length];
        int[] suffixArray = new int[numbers.length];

        Arrays.fill(prefixArray, 1);
        Arrays.fill(suffixArray, 1);

        for (int i = 1; i < numbers.length; i++) { // not start at beginning
            prefixArray[i] = prefixArray[i - 1] /* <- this part is the same as a normal prefix builder */
                * numbers[i - 1]; // at index mult everything before this index
        }

        for (int i = numbers.length - 2; i >= 0; i--) { // not start at the last index
            suffixArray[i] = suffixArray[i + 1] /* <- this part is the same as a normal suffix builder */
                * numbers[i + 1]; // at index mult everything after this index
        }

        int[] answer = new int[numbers.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = prefixArray[i] * suffixArray[i]; // multiply both arrays together
        }

        return answer;
    }

    public static int[] productExceptSelfBruteForce(int[] nums) {
        // return an array of numbers which are the products of all other numbers in array except for i
        // Thinking amaglum of sliding widow and 2 pointer

        // beginning 1 -> length - 1
        // last index 0 -> i - 1
        // else 0 -> i - 1 && i + 1 -> len - 1
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currentTotal = 1;

            if (i == 0) {
                for (int k = 1; k < nums.length; k++) {
                    currentTotal *= nums[k];
                }
                output[i] = currentTotal;
            } else if (i == nums.length - 1) {
                for (int k = 0; k < nums.length - 1; k++) {
                    currentTotal *= nums[k];
                }
                System.out.println(i);
                output[i] = currentTotal;
            } else {
                for (int k = 0; k < i; k++) {
                    currentTotal *= nums[k];
                }

                for (int k = i + 1; k < nums.length; k++) {
                    currentTotal *= nums[k];
                }
                output[i] = currentTotal;
            }
        }

        return output;
    }

}
