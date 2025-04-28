package org.example.leetcode.linkedlist;

import org.example.ListNode;

public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (prev != null && prev.value == current.value) {
                prev.next = current.next;
            }

            prev = current;
            current = current.next;

            while (current != null &&
                current.next != null &&
                current.value == current.next.value) {
                current.next = current.next.next;
            }
        }

        return head;
    }
}
