package org.example.leetcode.binarysearch;

public class IsPerfectSquare {
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long product = mid * mid;

            if (product == (long) num) {
                return true;
            }

            if (product > (long) num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
