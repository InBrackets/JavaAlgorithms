package com.odoo.goudadev.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayPartitionTest extends AbstractTest {

    ArrayPartition base = new ArrayPartition();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testArrayPairSum_13ms(int[] nums, int output) {
        assertEquals(output, base.arrayPairSum_13ms(nums));
    }

    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 4, 3, 2},
                4
            ),
            Arguments.of(
                new int[]{6, 2, 6, 5, 1, 2},
                9
            )
        );
    }
}