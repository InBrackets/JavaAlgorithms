package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.HARD;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(HARD)
})
class FirstMissingPositiveTest extends AbstractTest {

    FirstMissingPositive base = new FirstMissingPositive();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testFirstMissingPositive_2ms(int[] nums, int output) {
        assertEquals(output, base.firstMissingPositive_2ms(nums));
    }

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testFirstMissingPositive_13ms(int[] nums, int output) {
        assertEquals(output, base.firstMissingPositive_13ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 2, 0},
                3
            ),
            Arguments.of(
                new int[]{3, 4, -1, 1},
                2
            ),
            Arguments.of(
                new int[]{7, 8, 9, 11, 12},
                1
            )
        );
    }
}