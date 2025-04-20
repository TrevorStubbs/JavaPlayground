package org.example.dailypractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyPracticeApril20 {
    // binarySearch
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(key == array[mid]) {
                return true;
            }

            if(key < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    // twoPointerOneInput
    public static boolean twoSum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while(left < right) {
            int sum = array[left] + array[right];

            if(sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    // twoPointerTwoInput
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

    // slidingWindow
    public static List<Integer> subArrays(int[] array, int size) {
        List<Integer> output = new ArrayList<>();

        int counter = 0;

        for (int i = 0; i < size; i++) {
            counter += array[i];
        }

        output.add(counter);
        int left = size;

        for (int i = size; i < array.length; i++) {
            counter = counter - array[left] + array[i];
            output.add(counter);
            left++;
        }

        return output;
    }

    // prefix
    public static int[] prefixSum(int[] array) {
        int[] prefix = new int[array.length];
        Arrays.fill(prefix,0);
        prefix[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
        }

        return prefix;
    }

    public static int[] suffixSum(int[] array) {
        int[] suffix = new int[array.length];
        Arrays.fill(suffix, 0);
        suffix[suffix.length - 1] = array[array.length - 1];

        for (int i = array.length - 2; i>= 0; i--) {
            suffix[i] = suffix[i + 1] + suffix[i];
        }

        return suffix;
    }

    // prefixString
    public static String prefixString(String[] strings) {
        String prefix = strings[0];

        for (String string : strings) {
            while (string.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    // fastSlowPointer
    public static boolean fastSlow(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null ) {
            if(slow.value == fast.value) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // reverseLinkedList
    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while(current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // findSubArrays

    public static class ListNode {
        int value;
        ListNode next;
    }
}
