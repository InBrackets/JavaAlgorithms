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
class LongestIncreasingSubsequenceTest extends AbstractTest {

    LongestIncreasingSubsequence base = new LongestIncreasingSubsequence();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testLengthOfLIS_13ms(int[] nums, int output) {
        assertEquals(output, base.lengthOfLIS_13ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[] {10,9,2,5,3,7,101,18},
                4
            ),
            Arguments.of(
                new int[] {0,1,0,3,2,3},
                4
            ),
            Arguments.of(
                new int[] {7,7,7,7,7,7,7},
                1
            )
        );
    }
}