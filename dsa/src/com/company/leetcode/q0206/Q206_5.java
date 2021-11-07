package com.company.leetcode.q0206;

/**
 * 反转链表
 *
 * 迭代
 * 注意点：空链表；头结点与头结点.next 会形成循环链表
 * @author 赵丙双
 * @since 2021.09.15
 */
public class Q206_5 {
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = prev;
            prev = cur;
            cur = n;
        }

        head.next = null;

        return prev;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode listNode = reverseList(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


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


