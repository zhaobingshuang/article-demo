package com.company.leetcode.q0141;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.28
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        do {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        } while (fast != null && fast.next != null);
        return false;
    }
}
