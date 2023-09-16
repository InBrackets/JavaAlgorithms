package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.MEDIUM;
import static org.assertj.core.api.Assertions.assertThat;

@Tags({
    @Tag(MEDIUM)
})
class MergeIntervalsTest extends AbstractTest {

    MergeIntervals base = new MergeIntervals();

    @ParameterizedTest(name = "Case {index}: intervals={0}, output={1}")
    @MethodSource("generateTestData")
    void merge_11ms(int[][] intervals, int[][] output) {
        assertThat(base.merge_11ms(intervals)).isDeepEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                new int[][]{{1, 6}, {8, 10}, {15, 18}}
            ),
            Arguments.of(
                new int[][]{{1, 4}, {4, 5}},
                new int[][]{{1, 5}}
            )
        );
    }
}