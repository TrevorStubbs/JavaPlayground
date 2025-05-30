package org.example.dailypractice;

import org.example.ListNode;
import org.example.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DailyPracticeApril25 {
    // binarySearch
    public static boolean binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length-1;

        while(left<=right) {
            int mid = left + (right - left) / 2;
            if (key == array[mid]) {
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
        int right = array.length-1;

        while(left<=right){
            int sum = array[left] + array[right];

            if(sum == key) {
                return true;
            }

            if(key < sum){
                right--;
            } else {
                left++;
            }
        }

        return true;
    }

    // twoPointerTwoInput
    public static int[] mergeTwoArrays(int[] array1, int[] array2) {
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while(index1 < array1.length && index2<array2.length){
            if(array1[index1] < array2[index2]) {
                list.add(array1[index1]);
                index1++;
            } else {
                list.add(array2[index2]);
                index2++;
            }
        }

        while(index1<array1.length) {
            list.add(array1[index1]);
            index1++;
        }

        while(index2<array2.length){
            list.add(array2[index2]);
            index2++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // slidingWindow
    public static int[] slidingWindow(int[] array, int windowSize) {
        int[] output = new int[array.length];
        int counter = 0;

        for (int i = 0; i < windowSize; i++) {
            counter += array[i];
        }

        output[0] = counter;
        int left = 0;

        for (int i = windowSize; i < array.length; i++) {
            counter = counter - array[left] + array[i];
            left++;
        }

        return output;
    }

    // prefix
    public static int[] prefixArray(int[] array) {
        int[] prefix = new int[array.length];
        Arrays.fill(prefix, 0);
        prefix[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            prefix[i] = prefix[i - 1] + array[i];
        }
        return prefix;
    }

    // suffix
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
        ListNode slow = head;
        ListNode fast = head;

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


    // monotonic increasing stack
    public static int monoStack(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int num : array) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            stack.push(num);
        }
        return answer;
    }

    // binaryTreeDfs(recursive)
    public static boolean dsfR(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.value == key) {
            return true;
        }

        return dsfR(root.left, key) || dsfR(root.right, key);
    }

    // binaryTreeDfs(iterative)
    public static boolean dsfI(TreeNode root, int key) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.value == key) {
                return true;
            }

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return false;
    }

    // binaryTreeBfs
    public static boolean bfs(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; i++) {

                TreeNode current = queue.remove();
                if (current.value == key) {
                    return true;
                }

                if (current.left != null) {
                    queue.add(root.left);
                }

                if (current.right != null) {
                    queue.add(root.right);
                }
            }
        }
        return false;
    }

}
