package com.odoo.goudadev.dynamicprogramming;

import com.odoo.goudadev.array.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class NthNumberInFibonacciSequenceTest extends AbstractTest {

    @ParameterizedTest(name = "Case {index}: n={0}, output={1}")
    @MethodSource("generateTestData")
    void testMemoizeWay(long n, long output) {
        assertEquals(output, NthNumberInFibonacciSequence.memoizeWay(n));
    }

    @ParameterizedTest(name = "Case {index}: n={0}, output={1}")
    @MethodSource("generateTestData")
    void testRecursiveWay(long n, long output) {
        assumeTrue(n<=6, "Above 6 the algorithm is not efficient due to the time complexity is O(2^n)");
        assertEquals(output, NthNumberInFibonacciSequence.recursiveWay(n));
    }

    @BeforeEach
    void cleanUp() {
        NthNumberInFibonacciSequence.memos = new HashMap<>();
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(1, 1),
            Arguments.of(2, 1),
            Arguments.of(3, 2),
            Arguments.of(6, 8),
            Arguments.of(8, 21),
            Arguments.of(10, 55),
            Arguments.of(50, 12586269025L)
        );
    }
}