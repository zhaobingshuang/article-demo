package com.company.leetcode.q0206;

/**
 *
 * 反转链表
 * 迭代 - 臃肿
 *
 * @author 赵丙双
 * @since 2021.09.15
 */
public class Q206_4 {
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = head.next.next;

        while (true) {
            node2.next = node1;
            if (node3 == null) {
                head.next = null;
                return node2;
            }

            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
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


