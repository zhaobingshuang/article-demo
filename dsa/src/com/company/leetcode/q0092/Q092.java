package com.company.leetcode.q0092;

/**
 * 头插法
 *
 * @author 赵丙双
 * @since 2021.09.17
 */
public class Q092 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode cur = prev.next;
        int i = left;

        while (i < right) {
            ListNode next = cur.next;
            // 删除节点
            cur.next = next.next;
            // 查到头部
            next.next = prev.next;
            prev.next = next;

            i++;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        new Q092().reverseBetween(n1, 2, 4);
    }
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1, head);
        ListNode prev = dummyNode;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode leftNode = prev.next;
        while (left < right) {
            ListNode next = leftNode.next;
            leftNode.next = next.next;
            next.next = prev.next;
            prev.next = next;
            left++;
        }

        return dummyNode.next;
    }


}
