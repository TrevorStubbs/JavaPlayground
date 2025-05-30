package org.example.dailypractice;

import org.example.ListNode;
import org.example.learning.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DailyPracticeMay02 {
    // binarySearch
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

    // twoPointerOneInput
    public static boolean twoPointer1(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int sum = array[left] + array[right];

            if (key == sum) {
                return true;
            }

            if (key < sum) {
                right--;
            } else {
                left++;
            }
        }

        return true;
    }

    // twoPointerTwoInput
    public static int[] twoPointer2(int[] array1, int[] array2) {
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                list.add(array1[index1]);
                index1++;
            } else {
                list.add(array2[index2]);
                index2++;
            }
        }

        while (index1 < array1.length) {
            list.add(array1[index1]);
            index1++;
        }

        while (index2 < array2.length) {
            list.add(array2[index2]);
            index2++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // slidingWindow
    public static int[] slidingWindow(int[] array, int windowSize) {
        List<Integer> list = new ArrayList<>();
        int counter = 0;

        for (int i = 0; i < windowSize; i++) {
            counter += array[i];
        }

        list.add(counter);
        int left = 0;

        for (int i = windowSize; i < array.length; i++) {
            counter = counter - list.get(left) + array[i];
            list.add(counter);
            left++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // prefix
    public static int[] prefix(int[] array) {
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);

        for (int i = 1; i < array.length; i++) {
            list.add(list.get(i - 1) + array[i]);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // suffix
    public static int[] suffix(int[] array) {
        int[] suffix = new int[array.length];
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
        ListNode fast = head.next;

        while (slow != null && fast != null) {
            if (fast == slow) {
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

    // binaryTreeDfs(recursive)
    public static boolean dsf(TreeNode root, int key) {
        if (root == null) {
            return false;
        }

        if (root.value == key) {
            return true;
        }

        return dsf(root.left, key) || dsf(root.right, key);
    }

    // binaryTreeDfs(iterative)
    public static boolean dsfIterate(TreeNode root, int key) {
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
    public static boolean bsf(TreeNode root, int key) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for (int i = 0; i < currentLevel; i++) {
                TreeNode current = queue.remove();

                if (current.value == key) {
                    return true;
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
        }

        return false;
    }
}
