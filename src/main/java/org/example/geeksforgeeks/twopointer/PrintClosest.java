package org.example.geeksforgeeks.twopointer;

public class PrintClosest {
    public static int[] printClosest(int[] array1, int[] array2, int key) {
        int difference = Integer.MAX_VALUE;

        int resultLeft = 0;
        int resultRight = 0;
        int left = 0;
        int right = array2.length - 1;

        while(left < array1.length && right >= 0) {
            if(Math.abs(array1[left] + array2[right] - key) < difference) {
                resultLeft = left;
                resultRight = right;
                difference = Math.abs(array1[left] + array2[right] - 1);
            }

            if(array1[left] + array2[right] > key) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {array1[resultLeft], array2[resultRight]};
    }
}
