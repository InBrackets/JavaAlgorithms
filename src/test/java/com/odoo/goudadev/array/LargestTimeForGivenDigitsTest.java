package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.FAVOURITE;
import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tags({
    @Tag(MEDIUM),
    @Tag(FAVOURITE)
})
class LargestTimeForGivenDigitsTest extends AbstractTest {

    LargestTimeForGivenDigits base = new LargestTimeForGivenDigits();

    @ParameterizedTest(name = "Case {index}: arr={0}, output={1}")
    @MethodSource("generateTestData")
    void testLargestTimeFromDigits(int[] arr, String output) {
        assumeTrue(arr.length == 4);
        assertEquals(output, base.largestTimeFromDigits_0ms(arr));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[] {1,2,3,4},
                "23:41"
            ),
            Arguments.of(
                new int[] {4,3,2,1},
                "23:41"
            ),
            Arguments.of(
                new int[] {9,9,1,5},
                "19:59"
            ),
            Arguments.of(
                new int[] {3,3,1,3},
                "13:33"
            ),
            Arguments.of(
                new int[] {5,5,5,5},
                ""
            )
        );
    }


}