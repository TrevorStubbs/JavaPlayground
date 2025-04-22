package org.example.dailypractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyPracticeApril21 {
    // binarySearch
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

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
    public static boolean twoSum(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        int counter = array[left] + array[right];

        while (left <= right) {
            if (counter == key) {
                return true;
            }

            if(counter < key) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    // twoPointerTwoInput
    public static List<Integer> mergeTwoArrays(int[] array1, int[] array2) {
        List<Integer> output = new ArrayList<>();

        int indexOne = 0;
        int indexTwo = 0;

        while (indexOne < array1.length && indexTwo < array2.length) {
            if(array1[indexOne] < array2[indexTwo]) {
                output.add(array1[indexOne]);
                indexOne++;
            } else {
                output.add(array2[indexTwo]);
                indexTwo++;
            }
        }

        while(indexOne < array1.length) {
            output.add(array1[indexOne]);
            indexOne++;
        }

        while (indexTwo < array2.length) {
            output.add(array2[indexTwo]);
            indexTwo++;
        }

        return output;
    }

    // slidingWindow
    public static int[] sumOfSubArrays(int[] array, int windowSize) {
        int[] output = new int[array.length];
        Arrays.fill(output, 0);
        int counter = 0;

        for (int i = 0; i < windowSize; i++) {
            counter += array[i];
        }

        output[0] = counter;

        for (int i = windowSize; i < array.length; i++) {
            counter += counter - array[i-1] + array[i];
            output[i] = counter;
        }

        return output;
    }

    // prefix
    public static int[] prefixSum(int[] array) {
        int[] prefix = new int[array.length];
        Arrays.fill(prefix, 0);

        prefix[0] = array[0];

        for(int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i -1] + array[i];
        }

        return prefix;
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
    public static boolean fastSlowPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && slow != null) {
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

    // findSubArrays
    public static int findSubArray(int[] array, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int answer = 0;
        int current = 0;

        for (int num : array) {
            current += num; // do logic to change current
            answer += counts.getOrDefault(current - k, 0);
            counts.put(current, counts.getOrDefault(current, 0) + 1);
        }

        // do logic to fill answer

        return answer;
    }

    public static class ListNode {
        int value;
        ListNode next;
    }
}
