package com.company.leetcode.q0206;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.15
 */
public class Q206_3 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = reverse(head);
        head.next = null;
        return tail;
    }

    public ListNode reverse(ListNode head) {
        // head == null 空链表的特除情况
        // head.next == null 不需要与后继子链表反转
        if (head.next == null) {
            return head;
        }

        // 先反转 head 的后继子链表
        ListNode p = reverseList(head.next);
        // 在将 head 与后继子链表反转
        head.next.next = head;
        return p;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


