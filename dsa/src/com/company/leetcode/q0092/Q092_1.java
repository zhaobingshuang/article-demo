package com.company.leetcode.q0092;

/**
 * 切分 - 用哑元节点
 *
 * @author 赵丙双
 * @since 2021.09.18
 */
public class Q092_1 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode beforeNode = dummyNode;

        for (int i = 0; i < left - 1; i++) {
            beforeNode = beforeNode.next;
        }

        ListNode leftNode = beforeNode.next;
        ListNode rightNode = leftNode;

        for (int i = left; i < right; i++) {
            rightNode = rightNode.next;
        }

        ListNode afterNode = rightNode.next;

        beforeNode.next = null;
        rightNode.next = null;

        reverse(leftNode);

        beforeNode.next = rightNode;
        leftNode.next = afterNode;
        return dummyNode.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
