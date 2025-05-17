package org.example.leetcode.linkedlist;

import org.example.ListNode;

public class MiddleNode {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow!=null&&fast!=null){
            slow = slow.next;

            if(fast.next !=null){
                fast = fast.next.next;
            } else {
                fast = null;
            }
        }

        return slow;
    }
}
