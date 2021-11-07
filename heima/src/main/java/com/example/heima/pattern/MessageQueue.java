package com.example.heima.pattern;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class MessageQueue {

    private final LinkedList<Message> queue = new LinkedList();

    private final int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    @SneakyThrows
    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    @SneakyThrows
    public Message take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;

        }
    }
}
