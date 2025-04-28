package org.example.dailypractice;

import org.example.ListNode;
import org.example.TreeBuilder;
import org.example.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class DailyPracticeApril22 {
    // binarySearch
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return true;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // twoPointerOneInput
    public static boolean twoPointer1Input(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int counter = array[left] + array[right];

            if (counter == target) {
                return true;
            }

            if (target < counter) {
                right--;
            } else {
                left++;
            }
        }

        return false;
    }

    // twoPointerTwoInput
    public static List<Integer> twoPointer2Input(int[] array1, int[] array2) {
        List<Integer> output = new ArrayList<>();

        Arrays.sort(array1);
        Arrays.sort(array2);
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
    public static int[] slidingWindow(int[] array, int windowSize) {
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

        for (int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
        }

        return prefix;
    }

    public static int[] suffixSum(int[] array) {
        int[] prefix = new int[array.length];
        Arrays.fill(prefix, 0);

        prefix[array.length - 1] = array[array.length - 1];

        for (int i = array.length - 2; i >= 0; i--) {
            prefix[i] = prefix[i + 1] + prefix[i];
        }

        return prefix;
    }

    // prefixString
    public String prefixString(String[] strings) {
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

        while (fast != null && slow != null) {
            if (fast.value == slow.value) {
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

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    // findSubArrays
    public static int findSubArrays(int[] array, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int answer = 0;
        int current = 0;

        for (int num : array) {
            // do logic to change current
            answer += counts.getOrDefault(current - k, 0);
            counts.put(current, counts.getOrDefault(current, 0) + 1);
        }

        return answer;
    }


    // monotonic increasing stack
    public static int monotonicIncreasingStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for(int num : array){
            while(!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            stack.push(num);
        }

        return answer;
    }

    // BinaryTreeDFSRec
    public static boolean binaryTreeDFSRec(TreeNode root, int target) {
        if(root == null) {
            return false;
        }

        if(root.value == target) {
            return true;
        }

        return binaryTreeDFSRec(root.left, target) || binaryTreeDFSRec(root.right, target);
    }
}
