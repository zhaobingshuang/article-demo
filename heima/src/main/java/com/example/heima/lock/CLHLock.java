package com.example.heima.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * xxx
 *
 * @author 赵丙双
 * @date 2021.05.08
 */
public class CLHLock {

    private static class Node {
        volatile boolean locked = false;
    }

    private final AtomicReference<Node> tail;

    private final ThreadLocal<Node> currentThreadNode;

    private final ThreadLocal<Node> predThreadNode;

    public CLHLock() {
        tail = new AtomicReference<>(new Node());
        
        currentThreadNode = ThreadLocal.withInitial(Node::new);

        predThreadNode = new ThreadLocal<>();
    }
    
    public void lock() {
        Node currentNode = currentThreadNode.get();
        currentNode.locked = true;

        Node preNode = tail.getAndSet(currentNode);
        predThreadNode.set(preNode);

        while (preNode.locked) {

        }
    }

    public void unlock() {
        Node currentNode = currentThreadNode.get();
        currentNode.locked = false;

        currentThreadNode.set(predThreadNode.get());

    }
}
