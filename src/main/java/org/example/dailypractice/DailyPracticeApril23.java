package org.example.dailypractice;

import org.example.ListNode;
import org.example.TreeBuilder;
import org.example.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailyPracticeApril23 {
    // binarySearch
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
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
    public static boolean twoSum(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int counter = array[left] + array[right];

            if (counter == key) {
                return true;
            }

            if (key < counter) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    // twoPointerTwoInput
    public static List<Integer> mergeTwoArrays(int[] array1, int[] array2) {
        List<Integer> output = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                output.add(array1[index1]);
                index1++;
            } else {
                output.add(array2[index2]);
                index2++;
            }
        }

        while (index1 < array1.length) {
            output.add(array1[index1]);
            index1++;
        }

        while (index2 < array2.length) {
            output.add(array2[index2]);
            index2++;
        }

        return output;
    }

    // slidingWindow
    public static int[] sumOfArrays(int[] array, int windowSize) {
        int[] output = new int[array.length];
        int counter = 0;

        for (int i = 0; i < windowSize; i++) {
            counter += array[i];
        }

        output[0] = counter;

        for (int i = windowSize; i < array.length; i++) {
            counter = counter - array[i - 1] + array[i];
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
            prefix[i] = prefix[i - 1] + array[i];
        }

        return prefix;
    }

    public static int[] suffixSum(int[] array) {
        int[] suffix = new int[array.length];
        Arrays.fill(suffix, 0);

        suffix[suffix.length - 1] = array[array.length - 1];

        for (int i = array.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + array[i];
        }

        return suffix;
    }

    // prefixString
    public static String prefixSum(String[] strings){
        String prefix = strings[0];

        for(String string : strings) {
            while (string.indexOf(prefix) != 0) {
                prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }

    // fastSlowPointer
    public static boolean fastSlow(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && slow != null) {
            if(fast.value == slow.value){
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }

    // reverseLinkedList
    public static ListNode reverse(ListNode head) {
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
    // monotonic increasing stack

    // binaryTreeDfs(recursive)
    public static boolean binaryTreeDsf(TreeNode root, int key) {
        if(root == null) {
            return false;
        }

        if(root.value == key) {
            return true;
        }

        return binaryTreeDsf(root.left, key) || binaryTreeDsf(root.right, key);
    }



}
