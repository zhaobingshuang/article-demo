package com.company.leetcode.q0206;

/**
 *
 * 反转链表
 *
 * 将问题分解为两个子问题：
 * head后继子链表的内部反转；head 与后继子链表反转；（先进行后继子链表的内部反转，然后后继子链表与head再反转）
 * 后继子链表的内部反转也可以拆分为一样的子问题
 * 问题拆到最后，就只剩下 head（尾结点） 与 null 的反转，此时不需要反转，是基准情况
 *
 * 注意点：空链表；头结点与头结点.next 会形成循环链表
 * @author 赵丙双
 * @since 2021.09.28
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = reverse(head);
        head.next = null;
        return tail;
    }

    public ListNode reverse(ListNode node) {
        // 尾节点
        if (node.next == null) {
            return node;
        }

        ListNode tail = reverse(node.next);
        node.next.next = node;
        return tail;
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


