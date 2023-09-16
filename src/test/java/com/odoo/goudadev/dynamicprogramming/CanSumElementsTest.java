package com.odoo.goudadev.dynamicprogramming;

import com.odoo.goudadev.array.AbstractTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CanSumElementsTest extends AbstractTest {

    @ParameterizedTest(name = "Case {index}: targetSum={0}, numbers={1}, output={2}")
    @MethodSource("generateTestData")
    void canSumRecursiveWay(long targetSum, List<Long> numbers, boolean output) {
        assertEquals(output, CanSumElements.canSumRecursiveWay(targetSum, numbers));
    }

    @ParameterizedTest(name = "Case {index}: targetSum={0}, numbers={1}, output={2}")
    @MethodSource("generateTestData")
    void canSumMemoizeWay(long targetSum, List<Long> numbers, boolean output) {
        assertEquals(output, CanSumElements.canSumMemoizeWay(targetSum, numbers));
    }

    @BeforeEach
    void cleanUp() {
        CanSumElements.memo = new HashMap<>();
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                7,
                List.of(2L,3L),
                true
            ),
            Arguments.of(
                7,
                List.of(5L,3L,4L,7L),
                true
            ),
            Arguments.of(
                7,
                List.of(2L,4L),
                false
            ),
            Arguments.of(
                8,
                List.of(2L,3L,5L),
                true
            ),
            Arguments.of(
                300,
                List.of(7L,14L),
                false
            )
        );
    }

    // console.log(canSum(7, [2, 3])); // true
    //console.log(canSum(7, [5, 3, 4, 7])); // true
    //console.log(canSum(7, [2, 4])); // false
    //console.log(canSum (8, [2, 3, 5])); // true
    //console.log(canSum (300, · [7, -14])); · //..false
}