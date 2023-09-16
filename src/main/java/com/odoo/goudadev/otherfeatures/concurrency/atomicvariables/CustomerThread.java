package com.odoo.goudadev.otherfeatures.concurrency.atomicvariables;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;

@Slf4j
@Getter
class CustomerThread extends Thread {

    @Getter
    private static volatile HashSet<Customer> customers = new HashSet<>();

    CustomerThread(ThreadGroup threadGroup, String threadName) {
        super(threadGroup, threadName);
    }

    @Override
    public void run() {
        Customer customer = new Customer();
        addCustomerToSet(customer);
        log.info("Customer with id={} has been created", customer.getId());
    }

    private synchronized void addCustomerToSet(Customer customer) {
        customers.add(customer);
    }

}
