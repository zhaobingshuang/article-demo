package com.company.leetcode.q0092;

/**
 *
 * 切分 - 不用哑元节点
 * 一次遍历：自创的
 *
 * 将链表分为
 * head ...... before left ...... right after ...
 * 输入 [1  2  3  4  5]  2, 4
 * 先反转 left 到 right，但同时要保留 before、after 的指针
 * left 会成为子链表的尾，right 会成为头
 * 然后重新连接即可 before.next = right; left.next = after;
 *
 * 反转子链表
 * 1 <-> 2 <- 3 <- 4  5
 *
 * before.next = right
 * 1 -> 4
 * 结果
 * 1 -> 4 -> 3 -> 2  5
 *
 * left.next = after
 * 2 -> 5
 * 结果
 * 1 -> 4 -> 3 -> 2 -> 5
 *
 *
 * 注意点：
 * 1. 若 left == right 则无需反转
 * 2. 注意没有 before 或 after 的情况
 *  没有 after 也要将 left.next = after，否则会造成循环 before -> left  left -> before
 * 3. 返回链表时要区分 left == 1， 是则返回子链表的头，否则返回主链表的 head
 *
 * @author 赵丙双
 * @since 2021.09.17
 */
public class Q092_2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
//        head == null || head.next == null || 此条件不需要了
        if (left == right) {
            return head;
        }

        int i = 1;

        ListNode before = null;
        ListNode subHead = null;
        ListNode after = null;

        ListNode prev = null;
        ListNode cur = head;


        while (i <= right) {
            // 记录 before 和子链表的头
            if (i == left) {
                before = prev;
                subHead = cur;
            }

            // 记录 after
            if (i == right) {
                after = cur.next;
            }

            ListNode next = cur.next;
            // 只有在范围内才反转节点，否则只后移指针
            if (i >= left) {
                cur.next = prev;
            }

            prev = cur;
            cur = next;

            i++;
        }

        // 下面的简写，没有 after 也要将 left.next = after，否则会造成循环 before -> left  left -> before
        subHead.next = after;
//        if (after != null) {
//            subHead.next = after;
//        } else {
//            subHead.next = null;
//        }

        // before.next = right; prev 是子链表的头
        if (before != null) {
            before.next = prev;
        }

        // 返回链表时要区分 left == 1， 是则返回子链表的头，否则返回主链表的 head
        if (left == 1) {
            return prev;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
//        ListNode n5 = new ListNode(5);
//        ListNode n4 = new ListNode(4, n5);
//        ListNode n3 = new ListNode(3, n4);
//        ListNode n2 = new ListNode(2, n3);
//        ListNode n1 = new ListNode(1, n2);
//
//        new Q092_2().reverseBetween(n1, 2, 4);

        ListNode n3 = new ListNode(3, null);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode listNode = new Q092_2().reverseBetween(n1, 2, 3);

    }

}
