package org.example.leetcode.binarysearch;

public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int start = 0;
        int end = n;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if(isBadVersion(mid) && !isBadVersion(mid + 1)) {
                return mid;
            }

            if(isBadVersion(mid) && isBadVersion(mid + 1)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private static boolean isBadVersion(int n) {
        return n >= 4;
    }
}
