package com.odoo.goudadev.otherfeatures.concurrency;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The same Class as {@link Customer}, with a difference of using the {@link AtomicInteger}, instead of using the volatile (for fields) and synchronized (for methods) keywords
 */
@Getter
@Slf4j
public class AtomicCustomer {

    private static AtomicInteger idCounter = new AtomicInteger(0);

    private final int id;

    public AtomicCustomer() {
        id = idCounter.getAndIncrement();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("Exception has been thrown");
            throw new RuntimeException(e);
        }
    }

    public static void resetCounter() {
        idCounter = new AtomicInteger(0);
    }
}
