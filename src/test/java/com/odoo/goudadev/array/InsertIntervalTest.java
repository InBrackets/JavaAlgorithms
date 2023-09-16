package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tags({
    @Tag(MEDIUM)
})
class InsertIntervalTest extends AbstractTest {

    InsertInterval base = new InsertInterval();

    @ParameterizedTest(name = "Case {index}: intervals={0}, newInterval={1}, output={2}")
    @MethodSource("generateTestData")
    void testInsert_1ms(int[][] intervals, int[] newInterval, int[][] output) {
        assumeTrue(intervals.length <= 104);
        assumeTrue(newInterval.length == 2);
        assertThat(base.insert_1ms(intervals, newInterval)).isDeepEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[][]{{1, 3}, {6, 9}},
                new int[]{2, 5},
                new int[][]{{1, 5}, {6, 9}}
            ),
            Arguments.of(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                new int[]{4, 8},
                new int[][]{{1, 2}, {3, 10}, {12, 16}}
            )
        );
    }
}