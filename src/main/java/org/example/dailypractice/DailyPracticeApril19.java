package org.example.dailypractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyPracticeApril19 {
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (key == array[mid])
                return true;

            if (key < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static int twoPointerOneInput(int[] array) {
        int left = 0;
        int right = array.length;
        int answer = 0;

        while (left < right) {
            // some condition

            if (true) {
                answer++;
                left++;
            } else {
                right--;
            }
        }

        return answer;
    }

    public static int twoPointerTwoInput(int[] array1, int[] array2) {
        int index1 = 0;
        int index2 = 0;
        int answer = 0;

        while(index1 < array1.length && index2 < array2.length) {
            // some condidtion
            if (true) {
                index1++;
            } else {
                index2++;
            }
        }

        while(index1 < array1.length){
            // process the rest from array 1
            index1++;
        }

        while(index2 < array2.length) {
            // process the rest of array 2
            index2++;
        }

        return answer;
    }

    public static List<Integer> slidingWindow(int[] array, int windowSize) {
        List<Integer> list = new ArrayList<>();

        int counter = 0;

        for (int i = 0; i < windowSize; i++) {
            counter += array[i];
        }

        list.add(counter);
        int windowStart = 0;

        for (int i = windowSize; i < array.length; i++) {
            counter = counter - array[windowStart] + array[i];
            System.out.println(array[windowStart]);
            list.add(counter);
            windowStart++;
        }

        return list;
    }

    public static int[] prefixSum(int[] numbers) {
        int[] prefix = new int[numbers.length];
        Arrays.fill(prefix,0);
        prefix[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        return prefix;
    }

    public static int[] prefixProduct(int[] numbers) {
        int[] prefix = new int[numbers.length];
        Arrays.fill(prefix, 1);
        prefix[0] = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            prefix[i] = prefix[i - 1] * numbers[i];
        }

        return prefix;
    }

    public static int[] suffixSum(int[] numbers){
        int[] suffix = new int[numbers.length];
        Arrays.fill(suffix, 0);

        suffix[suffix.length - 1] = numbers[numbers.length-1];

        for (int i = numbers.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + numbers[i];
        }

        return suffix;
    }

    public static int[] suffixProduct(int[] numbers) {
        int[] suffix = new int[numbers.length];
        Arrays.fill(suffix, 1);

        suffix[suffix.length - 1] = numbers[numbers.length - 1];

        for (int i = numbers.length - 2; i >= 0; i--){
            suffix[i] = suffix[i + 1] * numbers[i];
        }

        return suffix;
    }

    public static String prefixString(String[] input) {
        String prefix = input[0];

        for (int i = 1; i < input.length; i++) {
            while(input[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    public static int fastSlowPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            if (fast.value == slow.value) {
                return fast.value;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return -1;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode.next;
        }

        return prev;
    }

    public static class ListNode {
        int value;
        ListNode next;
    }
}
