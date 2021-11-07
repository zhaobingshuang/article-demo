package com.example.heima;

/**
 * xxx
 *
 * @author 赵丙双
 * @since 2021.09.11
 */
public class ReverseList {

    public static void main(String[] args) {
        Node node3 = new Node(3);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        print(node1);

        System.out.println("===");

        print(driver(node1));

        System.out.println("===");
        print(node1);

    }

    public static Node driver(Node node) {
        Node header = reverse(node);
        node.next = null;
        return header;
    }

    public static Node reverse(Node node) {
        if (node.next == null) {
            return node;
        }
        Node head = reverse(node.next);
        node.next.next = node;
        return head;
    }


    static class Node {
        int val;

        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }

        do {
            System.out.println(node.val);
            node = node.next;
        } while (node != null);
    }
}
