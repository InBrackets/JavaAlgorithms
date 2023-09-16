package com.odoo.goudadev.otherfeatures.concurrency;

import com.odoo.goudadev.array.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
/**
 * Inspired by {@see <a href="https://youtu.be/71dgtPrbToE?si=_3Ol-W23Ll6c3r0n">Youtube | The Volatile and Synchronized Keywords in Java | Atomic Variables | Java Multithreading | Geekific</a> }
 */
class AtomicVariablesExampleTest extends AbstractTest {

    public static AtomicReferenceArray<AtomicCustomer> atomicCustomers;
    public static volatile HashSet<Customer> customers = new HashSet<>();
    public static HashSet<AtomicCustomer> atomicCustomersSet = new HashSet<>();
    public static final int THREAD_COUNT = 10000;
    @BeforeEach
    void beforeEach() {
        AtomicCustomer.resetCounter();
        atomicCustomersSet.clear();
        atomicCustomers = new AtomicReferenceArray<>(THREAD_COUNT);


        customers.clear();
    }

    @ParameterizedTest(name = "Case {index}: THREAD_COUNT={0}")
    @MethodSource("generateTestData")
    void testAtomicVariablesInConcurrency(int THREAD_COUNT) {
            ThreadGroup threadGroupOne = new ThreadGroup("ThreadGroupOne");

            for (int i = 0; i < THREAD_COUNT; i++) {
                AtomicCustomerThread t1 = new AtomicCustomerThread(threadGroupOne, "Thread-" + i, atomicCustomers);
                t1.start();
            }
            while (threadGroupOne.activeCount() != 0) {
                // wait until all threads are done
            }
            // save all customers to a set in order to get rid of the null values
            for (int i = 0; i < atomicCustomers.length(); i++) {
                if (atomicCustomers.get(i) == null) {
                    continue;
                }
                atomicCustomersSet.add(atomicCustomers.get(i));
            }
            // all customers with unique id should be present
            assertEquals(THREAD_COUNT, atomicCustomersSet.size());
    }

    @ParameterizedTest(name = "Case {index}: THREAD_COUNT={0}")
    @MethodSource("generateTestData")
    @Disabled("This is not an appropriate way for defining thread fields. Test fails despite synchronized methods and volatile field.")
    void testVolatileVariablesInConcurrency(int THREAD_COUNT) {
        ThreadGroup threadGroupOne = new ThreadGroup("ThreadGroupOne");

        for (int i = 0; i < THREAD_COUNT; i++) {
            CustomerThread t1 = new CustomerThread(threadGroupOne, "Thread-" + i);
            t1.start();
        }
        while (threadGroupOne.activeCount() != 0) {
            // wait until all threads are done
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertEquals(THREAD_COUNT, CustomerThread.getCustomers().size());
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(1),
            Arguments.of(5),
            Arguments.of(10),
            Arguments.of(100),
            Arguments.of(1000)
        );
    }
}