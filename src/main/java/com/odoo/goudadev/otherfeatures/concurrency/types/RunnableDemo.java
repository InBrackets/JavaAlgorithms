package com.odoo.goudadev.otherfeatures.concurrency.types;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RunnableDemo {

    public static Callable<String> create2SecondsTask() {
        return () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                return "Returning after sleeping for 2 seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        };
    }
}
