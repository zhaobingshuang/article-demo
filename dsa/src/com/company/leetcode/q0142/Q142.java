package com.company.leetcode.q0142;

/**
 * 环形链表 - 官方
 * 是否有环：快慢指针
 * 特殊情况：整个都是一个环，起点相同的话，第一次相遇肯定是在起点 p != slow 条件不成立，直接返回 p
 * 若 fast = head.next，会导致第一次相遇不是在起点，进而使 内层的 while 循环无法结束（因为p、slow 步长都是 1，谁都追不上谁）
 *
 * @author 赵丙双
 * @since 2021.09.16
 */
public class Q142 {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }



    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        n4.next = n1;

        ListNode listNode = detectCycle(n1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

