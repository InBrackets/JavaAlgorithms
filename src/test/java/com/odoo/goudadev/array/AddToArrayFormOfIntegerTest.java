package com.odoo.goudadev.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddToArrayFormOfIntegerTest extends AbstractTest {

    private final static AddToArrayFormOfInteger base = new AddToArrayFormOfInteger();

    @ParameterizedTest(name = "Case {index}: num={0}, k={1}, output={2}")
    @MethodSource("generateTestData")
    void testAddToArrayForm_2ms(int[] num, int k, List<Integer> output) {
        assertEquals(output, base.addToArrayForm_2ms(num, k));
    }

    @ParameterizedTest(name = "Case {index}: num={0}, k={1}, output={2}")
    @MethodSource("generateTestData")
    void testAddToArrayForm_89ms(int[] num, int k, List<Integer> output) {
        assertEquals(output, base.addToArrayForm_2ms(num, k));
    }

    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 2, 0, 0},
                34,
                List.of(1, 2, 3, 4)
            ),
            Arguments.of(
                new int[]{2, 7, 4},
                181,
                List.of(4, 5, 5)
            ),
            Arguments.of(
                new int[]{2, 1, 5},
                806,
                List.of(1, 0, 2, 1)
            )
        );
    }
}