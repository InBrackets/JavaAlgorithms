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

class GridTravelerTest extends AbstractTest {

    @ParameterizedTest(name = "Case {index}: height={0}, width={1}, output={2}")
    @MethodSource("generateTestData")
    void gridTravellerMemoicWay(long height, long width, long output) {
        assertEquals(output, GridTraveler.gridTravellerMemoicWay(height, width));
    }

    @ParameterizedTest(name = "Case {index}: height={0}, width={1}, output={2}")
    @MethodSource("generateTestData")
    void gridTravellerRecursiveWay(long height, long width, long output) {
        assumeTrue((height + width) <= 33, "For larger values the algorithm is not efficient");
        assertEquals(output, GridTraveler.gridTravellerRecursiveWay(height, width));
    }

    @BeforeEach
    void cleanUp() {
        GridTraveler.memo = new HashMap<>();
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(2, 3, 3),
            Arguments.of(15, 15, 40116600),
            Arguments.of(2, 47, 47),
            Arguments.of(1, 3, 1),
            Arguments.of(20, 10, 6906900),
            Arguments.of(100, 100, 4631081169483718960L)
        );
    }
}