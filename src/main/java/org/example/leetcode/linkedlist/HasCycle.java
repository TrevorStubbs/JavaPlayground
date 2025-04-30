package org.example.leetcode.linkedlist;

import org.example.ListNode;

public class HasCycle {
    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast!=null && slow !=null) {
            if(slow == fast) {
                return true;
            }

            if(fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
