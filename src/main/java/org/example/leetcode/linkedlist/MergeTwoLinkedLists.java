package org.example.leetcode.linkedlist;

import org.example.ListNode;

public class MergeTwoLinkedLists {
    public static ListNode mergeTwoLinkedLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode outCurrent = null;
        ListNode head = null;

        if (list1.value <= list2.value) {
            head = list1;
            outCurrent = head;
            list1 = list1.next;
        } else {
            head = list2;
            outCurrent = head;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                outCurrent.next = list1;
                list1 = list1.next;
            } else {
                outCurrent.next = list2;
                list2 = list2.next;
            }

            outCurrent = outCurrent.next;
        }


        if (list1 != null) {
            outCurrent.next = list1;
        } else if (list2 != null) {
            outCurrent.next = list2;
        }

        return head;
    }
}
