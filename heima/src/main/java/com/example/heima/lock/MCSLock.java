package com.example.heima.lock;

import org.w3c.dom.Node;

import java.util.concurrent.atomic.AtomicReference;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.08
 */
public class MCSLock {



    private static class Node {
        volatile boolean locked = false;
        private volatile Node next;
    }

    private final AtomicReference<Node> tail;

    private final ThreadLocal<Node> currentThreadNode;


    public MCSLock() {
        tail = new AtomicReference<>();

        currentThreadNode = ThreadLocal.withInitial(Node::new);
    }

    public void lock() {
        Node node = currentThreadNode.get();
        Node pred = tail.getAndSet(node);
        if (pred != null) {
            node.locked = true;
            pred.next = node;
            while (node.locked) {
            }
        }
    }

    public void unlock() {
        Node node = currentThreadNode.get();

        if (node.next == null) {
            if (tail.compareAndSet(node, null)) {
                return;
            }
            while (node.next == null) {
            }
        }

        node.next.locked = false;
        node.next = null;
    }

}
