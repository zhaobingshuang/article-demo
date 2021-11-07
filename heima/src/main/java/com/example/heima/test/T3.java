package com.example.heima.test;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.28
 */
public class T3 {

    public ListNode reverseList(ListNode head) {
//        ListNode dummyNode = new ListNode(0, head);

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

    public ListNode reverseList2(ListNode head) {
//        ListNode dummyNode = new ListNode(0, head);
        ListNode newHead = reverseList2_1(head);
        if (head != null) {
            head.next = null;
        }
        return newHead;
    }

    public ListNode reverseList2_1(ListNode cur) {
//        ListNode dummyNode = new ListNode(0, cur);

        if (cur == null || cur.next == null) {
            return cur;
        }
        ListNode head = reverseList2_1(cur.next);
        cur.next.next = cur;
        return head;
    }


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