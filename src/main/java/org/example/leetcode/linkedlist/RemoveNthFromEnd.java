package org.example.leetcode.linkedlist;

import org.example.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }

        int indexToRemove = size - n;
        size = 0;
        current = head;

        ListNode prev = null;

        while (current != null) {
            if (size == indexToRemove) {
                if (prev == null) {
                    head = current.next;
                    return head;
                }

                prev.next = current.next;
                return head;
            }

            size++;
            prev = current;
            current = current.next;
        }

        return head;
    }
}
