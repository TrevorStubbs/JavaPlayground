package org.example.dailypractice;

import org.example.ListNode;

public class DailyPracticeApril17 {
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1; // Make sure we start at length - 1

        while(left <= right) { // search inclusive
            int mid = left + (right - left) / 2;
            if(array[mid] == key) {
                return true;
            }

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
            if (right == 4) { // some condition
                answer = array[right]; // some logic
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }

    public static int twoPointerTwoInput(int[] array1, int[] array2) {
        int index1 = 0;
        int index2 = 0;
        int answer = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == 5 && array2[index2] == 6) { // some conditional
                answer = 10; // do logic
                index1++;
            } else {
                index2++;
            }

            while(index1 < array1.length) {
                // do logic
                index1++;
            }

            while(index2 < array2.length) {
                // do logic
                index2++;
            }
        }

        return answer;
    }

    public static int slidingWindow(int[] array) {
        int left = 0;
        int answer = 0;
        int current = 0;

        for (int right = 0; right < array.length;  right++) {
            current = current + array[right];

            while (answer < current) { // some condition that breaks the window
                current = current - array[left];
                left++;
            }

            answer = current; // some answer update
        }

        return answer;
    }

    public static int[] prefix(int[] array) {
        int[] prefix = new int[array.length];
        prefix[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }

        return prefix;
    }

    public static String prefixString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        String prefix = strings[0];

        for (int i = 0; i < strings.length; i++) {
            while(prefix.indexOf(strings[i]) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static int fastSlowPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int answer = 0;

        while (fast != null || slow != null) {
            if (fast.value == slow.value) { // some logic
                return answer;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return answer;
    }

    public static ListNode reverseLinkedList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
