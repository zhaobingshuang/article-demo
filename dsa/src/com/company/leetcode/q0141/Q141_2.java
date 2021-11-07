package com.company.leetcode.q0141;

import java.util.HashSet;

/**
 * 环形链表
 * 是否有环：hash 表
 *
 * @author 赵丙双
 * @since 2021.09.23
 */
public class Q141_2 {

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null && set.add(cur)) {
            cur = cur.next;
        }

        if (cur != null) {
            return true;
        }
        return false;
    }
}