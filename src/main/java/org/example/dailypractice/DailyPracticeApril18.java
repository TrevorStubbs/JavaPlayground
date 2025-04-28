package org.example.dailypractice;

import org.example.ListNode;

import java.util.List;

public class DailyPracticeApril18 {
    // binarySearch
    public static boolean binarySearch(int[] array, int key) {
        if(array == null || array.length == 0) {
            return false;
        }

        int left = 0;
        int right = array.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if(key == array[mid]) {
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

    // twoPointerOneInput
    public static int twoPointerOneInput(int[] array) {
        int left = 0;
        int right = array.length;
        int answer = 0;

        while (left < right) {
            // some condition
            if (true) {
                answer = answer * 2;
                left++;
            } else {
                right++;
            }
        }

        return answer;
    }

    // twoPointerTwoInput
    public static int twoPointerTwoInput(int[] array1, int[] array2) {
        int indexOne = 0;
        int indexTwo = 0;
        int answer = 0;

        while(indexOne < array1.length && indexTwo < array2.length) {
            if(true) {
                answer = answer * 2;
                indexOne++;
            } else {
                indexTwo++;
            }

            while(indexOne < array1.length) {
                // do logic
                indexOne++;
            }

            while(indexTwo < array2.length) {
                // do logic
                indexTwo++;
            }
        }

        return answer;
    }

    // slidingWindow
    public static int slidingWindow(int[] array) {
        int left = 0;
        int answer = 0;
        int current = 0;

        for (int right = 0; right < array.length; right++) {
            current = current + array[left];

            while (answer < current) {
                current = current - array[left];
                left++;
            }

            answer = current;
        }

        return answer;
    }

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

    // prefix


    // prefixString
    public static String prefixString(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        String prefix = strings[0]; // start with full string

        for(int i = 0; i < strings.length; i++) {
            var thing = strings[i].indexOf(prefix); // if prefix isnt a substring of strings[i] then indexOf returns a -1
            var stuff = prefix.length();
            var things = prefix.substring(0, prefix.length() - 1);

            while(strings[i].indexOf(prefix) != 0) { // index of the beginning of prefix for string at index is not at index 0
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }


    // fastSlowPointer
    public static boolean fastSlowPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && slow != null) {
            if(fast.value == slow.value) {
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

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
