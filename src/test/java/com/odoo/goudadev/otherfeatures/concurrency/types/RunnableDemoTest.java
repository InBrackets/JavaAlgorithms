package com.odoo.goudadev.otherfeatures.concurrency.types;

import com.odoo.goudadev.array.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class RunnableDemoTest extends AbstractTest {

    private static List<String> threadNames = new ArrayList<>();
    private static Thread thread1;
    private static Thread thread2;


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
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return null;
    }
}