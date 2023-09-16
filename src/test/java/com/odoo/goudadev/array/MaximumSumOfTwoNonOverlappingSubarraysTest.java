package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static org.junit.jupiter.api.Assertions.*;

@Tags({
    @Tag(MEDIUM)
})
class MaximumSumOfTwoNonOverlappingSubarraysTest extends AbstractTest {

    MaximumSumOfTwoNonOverlappingSubarrays base = new MaximumSumOfTwoNonOverlappingSubarrays();

    @ParameterizedTest(name = "Case {index}: nums={0}, firstLen={1}, secondLen={2}, output={3}")
    @MethodSource("generateTestData")
    void maxSumTwoNoOverlap_3ms(int[] nums, int firstLen, int secondLen, int output) {
        assertEquals(output, base.maxSumTwoNoOverlap_3ms(nums, firstLen, secondLen));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[] {0,6,5,2,2,5,1,9,4},
                1,
                2,
                20
            ),
            Arguments.of(
                new int[] {3,8,1,3,2,1,8,9,0},
                3,
                2,
                29
            ),
            Arguments.of(
                new int[] {2,1,5,6,0,9,5,0,3,8},
                4,
                3,
                31
            )
        );
    }
}