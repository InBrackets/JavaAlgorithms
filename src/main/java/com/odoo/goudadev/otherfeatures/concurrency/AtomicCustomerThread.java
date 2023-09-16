package com.odoo.goudadev.otherfeatures.concurrency;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReferenceArray;

@Slf4j
@Getter
class AtomicCustomerThread extends Thread {

    private static AtomicReferenceArray<AtomicCustomer> customers;

    AtomicCustomerThread(ThreadGroup threadGroup, String threadName, AtomicReferenceArray<AtomicCustomer> customers) {
        super(threadGroup, threadName);
        AtomicCustomerThread.customers = customers;
    }

    @Override
    public void run() {
        AtomicCustomer customer = new AtomicCustomer();
        customers.set(customer.getId(), customer);
        log.info("Customer with id={} has been created", customer.getId());
    }

}
