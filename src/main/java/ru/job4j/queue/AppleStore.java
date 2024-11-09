package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String customerName = null;
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                customerName = queue.poll().name();
                break;
            }
            queue.poll();
        }
        return customerName;
    }

    public String getFirstUpsetCustomer() {
        String customerName;
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        customerName = queue.poll().name();
        return customerName;
    }
}
