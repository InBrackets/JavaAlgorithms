package com.odoo.goudadev.otherfeatures.concurrency.types;

import com.odoo.goudadev.array.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.odoo.goudadev.otherfeatures.concurrency.types.RunnableDemo.create2SecondsTask;

@Slf4j
class RunnableDemoTest extends AbstractTest {

    private static List<String> threadNames = new ArrayList<>();
    private static Thread thread1;
    private static Thread thread2;
    private static String result;



    @Test
    void testExecutorsStates() {

        Callable<String> task = create2SecondsTask();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // ExecutorService fixedExecutor = Executors.newFixedThreadPool(1); // The same as above but with a fixed max number of threads

        Future<String> future = executor.submit(task);

        log.info("Is it done -> {}", future.isDone());
        assertFalse(future.isDone());

        try {
            result = future.get(); // waits until result is ready
            result = future.get(3, TimeUnit.SECONDS); // same as above but with defined timeout
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        log.info("Is it done -> {}", future.isDone());
        assertTrue(future.isDone());

        log.info("Result -> {}", result);
        assertEquals("Returning after sleeping for 2 seconds", result);
    }


    @Test
    void testIfRunnablesAreExecutedByThread() {
        createRunnables();
        assertThat(threadNames).containsAll(List.of(thread1.getName(), thread2.getName()));
    }

    public static void createRunnables() {
        Runnable task = () -> {
            String name=Thread.currentThread().getName();
            log.info("Executing:" + name);
            threadNames.add(Thread.currentThread().getName());
        };
        thread1 = new Thread(task);
        thread1.start();
        thread2 = new Thread(task);
        thread2.start();

        // or in short -> new Thread(task).start();

        // we have to wait until the threads would be present
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return null;
    }
}