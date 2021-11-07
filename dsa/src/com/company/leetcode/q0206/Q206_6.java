package com.company.leetcode.q0206;

/**
 * 反转链表
 *
 * 迭代
 * pre 是 null，不是 head，所以不用考虑循环链表的问题
 * 注意点：空链表；头结点与头结点.next 会形成循环链表
 * @author 赵丙双
 * @since 2021.09.28
 */
public class Q206_6 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }

    static class ListNode {
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


