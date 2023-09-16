package com.odoo.goudadev.otherfeatures.concurrency.atomicvariables;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
/**
 * More flaky implementation of {@link AtomicCustomer}
 */
public class Customer {

    // volatile - the value is not cached, all operations are done on this exact field (reading, updating)
    private static volatile int idCounter = 0;

    private final int id;

    public Customer() {
        id = getAndIncrementId();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // synchronized - only 1 thread can execute this method at the same time.
    private synchronized int getAndIncrementId() {
        idCounter = idCounter + 1;
        return idCounter;
    }

    public static void resetCounter() {
        idCounter = 0;
    }
}
