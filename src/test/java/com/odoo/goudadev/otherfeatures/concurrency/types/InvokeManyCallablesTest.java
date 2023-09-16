package com.odoo.goudadev.otherfeatures.concurrency.types;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class InvokeManyCallablesTest {

    @Test
    void testInvokeAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
            newCallable("Task 1", 3),
            newCallable("Task 2", 2),
            newCallable("Task 3", 1)
        );
        executor.invokeAll(callables);
//        for (Future<String> future : executor.invokeAll(callables)) {
//            log.info(future.get());
//        }
        log.info(executor.invokeAny(callables));
    }

    Callable<String> newCallable(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            log.info(result);
            return result;
        };
    }
}
