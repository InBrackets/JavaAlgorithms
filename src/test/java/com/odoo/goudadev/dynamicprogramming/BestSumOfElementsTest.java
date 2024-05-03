package com.odoo.goudadev.dynamicprogramming;

import com.odoo.goudadev.array.AbstractTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BestSumOfElementsTest extends AbstractTest {

    @ParameterizedTest(name = "Case {index}: targetSum={0}, numbers={1}, output={2}")
    @MethodSource("generateTestData")
    void bestSumRecursiveWay(long targetSum, List<Long> numbers, List<Long> output) {
        assertThat(BestSumOfElements.bestSumRecursiveWay(targetSum, numbers).stream().sorted()).usingRecursiveComparison().isEqualTo(output);
    }

    @ParameterizedTest(name = "Case {index}: targetSum={0}, numbers={1}, output={2}")
    @MethodSource("generateTestData")
    void bestSumMemoicWay(long targetSum, List<Long> numbers, List<Long> output) {
        assertThat(BestSumOfElements.bestSumMemoicWay(targetSum, numbers).stream().sorted()).containsAll(output);
    }

    @BeforeEach
    void cleanUp() {
        BestSumOfElements.memo = new HashMap<>();
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
                Arguments.of(7, new ArrayList<>(List.of(5L, 3L, 4L, 7L)), new ArrayList<>(List.of(7L))),
                Arguments.of(8, new ArrayList<>(List.of(2L, 3L, 5L)), new ArrayList<>(List.of(3L, 5L))),
                Arguments.of(8, new ArrayList<>(List.of(1L, 4L, 50L)), new ArrayList<>(List.of(4L, 4L)))
           //     Arguments.of(100, new ArrayList<>(List.of(1L, 2L, 5L, 25L)), new ArrayList<>(List.of(25L, 25L, 25L, 25L)))
        );
    }
}