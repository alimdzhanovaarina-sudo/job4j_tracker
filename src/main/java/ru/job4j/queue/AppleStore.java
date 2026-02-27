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
        String lastHappyCustomerName = "";
        for (int i = 0; i < count; i++) {
            Customer customer = queue.poll();
            lastHappyCustomerName = customer.name();
        }
        return lastHappyCustomerName;
    }

    public String getFirstUpsetCustomer() {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        Customer firstUpsetCustomer = queue.poll();
        return firstUpsetCustomer.name();
    }
}







