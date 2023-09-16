package com.odoo.goudadev.dynamicprogramming;

import com.odoo.goudadev.array.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HowSumElementsTest extends AbstractTest {

    @ParameterizedTest(name = "Case {index}: targetSum={0}, numbers={1}, output={2}")
    @MethodSource("generateTestData")
    void howSumMemoicWay(long targetSum, List<Long> numbers, List<Long> output) {
        assertThat(HowSumElements.howSumMemoicWay(targetSum, numbers)).usingRecursiveComparison().isEqualTo(output);
    }

    @ParameterizedTest(name = "Case {index}: targetSum={0}, numbers={1}, output={2}")
    @MethodSource("generateTestData")
    void howSumRecursionWay(long targetSum, List<Long> numbers, List<Long> output) {
        assertThat(HowSumElements.howSumRecursionWay(targetSum, numbers)).usingRecursiveComparison().isEqualTo(output);
    }

    @BeforeEach
    void cleanUp() {
        HowSumElements.memo = new HashMap<>();
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                7, List.of(3L,2L,2L), List.of(2L,2L,3L)
            ),
            Arguments.of(
                7, List.of(5L,3L,4L,7L), List.of(4L,3L)
            ),
            Arguments.of(
                7, List.of(2L,4L), null
            ),
            Arguments.of(
                8, List.of(2L,3L,5L), List.of(2L,2L,2L,2L)
            ),
            Arguments.of(
                300, List.of(7L,14L), null
            )
        );
    }
}