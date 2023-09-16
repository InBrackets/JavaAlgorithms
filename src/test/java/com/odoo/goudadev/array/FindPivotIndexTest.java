package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.EASY;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tags({
    @Tag(EASY)
})
class FindPivotIndexTest extends AbstractTest {

    FindPivotIndex base = new FindPivotIndex();

    @ParameterizedTest(name = "Case {index}: nums={0}, output={1}")
    @MethodSource("generateTestData")
    void testPivotIndex_1ms(int[] nums, int output) {
        assertEquals(output, base.pivotIndex_1ms(nums));
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1, 7, 3, 6, 5, 6},
                3
            ),
            Arguments.of(
                new int[]{1, 2, 3},
                -1
            ),
            Arguments.of(
                new int[]{2, 1, -1},
                0
            )
        );
    }
}