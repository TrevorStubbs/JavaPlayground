package org.example.cheatsheets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheatSheet {
    // 2 pointer 1 input opposite ends
    public static Integer twoPointerOneInput(List<Integer> input) {
        int leftPointer = 0;
        int rightPointer = input.size() - 1;
        Integer answer = 0;
        boolean CONDITION = true; // define the conditional


        while (leftPointer < rightPointer) {
            // do some logic here with left and right
            if (CONDITION) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return answer;
    }

    // 2 pointer 2 input exhaust both
    public static Integer twoPointerTwoInput(List<Integer> inputListOne, List<Integer> inputListTwo) {
        int indexOne = 0;
        int indexTwo = 0;
        int answer = 0;
        boolean CONDITION = true; // define the conditional

        while (indexOne < inputListOne.size() && indexTwo < inputListTwo.size()) {
            if (CONDITION) {
                indexOne++;
            } else {
                indexTwo++;
            }
        }

        while (indexOne < inputListOne.size()) {
            // do logic
            indexOne++;
        }

        while (indexTwo < inputListTwo.size()) {
            // do logic
            indexTwo++;
        }

        return answer;
    }

    // sliding window
    // TREVOR - research this!
    public static Integer slidingWindow(List<Integer> inputList) {
        int leftIndex = 0;
        int answer = 0;
        int currentIndex = 0;
        boolean WINDOW_CONDITION = true; // define window condition

        for (int rightIndex = 0; rightIndex < inputList.size(); rightIndex++) {
            // do logic to add inputList[rightIndex] to current

            while (!WINDOW_CONDITION) { // window condition is broken
                // remove inputList[leftIndex] from current
                leftIndex++;
            }

            //update answer
        }

        return answer;
    }

    // build a prefix sum
    // TREVOR - research this!
    public static List<Integer> buildPrefixSum(List<Integer> inputList) {
        List<Integer> prefixList = new ArrayList<>();
        prefixList.add(inputList.get(0));

        for (int index = 1; index < inputList.size(); index++) { // start at 1 since we already added 0 to prefix list
            prefixList.add(index, prefixList.get(index - 1) - inputList.get(index));
        }

        return prefixList;
    }

    public static int[] buildPrefixSumRaw(int[] inputArray) {
        int[] prefixArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            prefixArray[i] = 0;
        }

        prefixArray[0] = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + inputArray[i];
        }

        return prefixArray;
    }

    public static int[] buildPrefixProduct(int[] inputArray) {
        int[] prefixArray = new int[inputArray.length];

//        for (int i = 0; i < inputArray.length; i++) {
//            prefixArray[i] = 1;
//        }

        Arrays.fill(prefixArray, 1);

        prefixArray[0] = inputArray[0];

        for (int i = 1; i < inputArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] * inputArray[i];
        }

        return prefixArray;
    }

    public static int[] buildSuffixSum(int[] inputArray) {
        int[] suffixSum = new int[inputArray.length];

        // initialized the sums to 0
        for (int i = 0; i < inputArray.length; i++) {
            suffixSum[i] = 0;
        }

        suffixSum[inputArray.length - 1] = inputArray[inputArray.length - 1];

        for (int i = inputArray.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + inputArray[i];
        }

        return suffixSum;
    }

    public static int[] buildSuffixProduct(int[] inputArray) {
        int[] suffixSum = new int[inputArray.length];

//        for (int i = 0; i < inputArray.length; i++) {
//            suffixSum[i] = 1; // initialize to 1 since 0 would cause it all go to 0
//        }

        Arrays.fill(suffixSum, 1);

        suffixSum[inputArray.length - 1] = inputArray[inputArray.length - 1];

        for (int i = inputArray.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] * inputArray[i];
        }

        return suffixSum;
    }

    // Efficient String building
    public static String stringBuilding(List<Character> characterList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : characterList) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    public static String stringBuilding2(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    // Linked List: fast and slow pointer
    public static int fastAndSlowPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int ans = 0;

        while (fast != null && fast.next != null) {
            // do logic
            slow = slow.next;
            fast = fast.next.next;
        }

        return ans;
    }

    // reversing a linked list
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

    // find number of subarrays that fit an exact criteria
    public int findSubArrays(int[] array, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int ans = 0;
        int current = 0;

        for (int num : array) {
            // do logic to change current
            ans += counts.getOrDefault(current - k, 0);
            counts.put(current, counts.getOrDefault(current, 0) + 1);
        }

        return ans;
    }

    // monotonic increasing stack
    // Binary tree: depth first (recursive)
    // Binary tree: depth first (iterative)
    // Binary tree: breadth first
    // Graph: Depth first (recursive)
    // Graph: Depth first (iterative)
    // Graph: Breadth first
    // Find top k elements with heap
    // Binary Search: no duplicates
    // Binary Search: duplicate elements, left-most insertion point
    // Binary Search: duplicate elements, right-most insertion point
    // Binary Search: greedy problems
    // Backtracking
    // Dynamic programming: top-down memoization
    // Build a trie
    // Dijkstra's Algorithm

    public static class ListNode {
        int value;
        ListNode next;
    }
}
