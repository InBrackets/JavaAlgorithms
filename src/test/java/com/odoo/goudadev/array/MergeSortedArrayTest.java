package com.odoo.goudadev.array;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.odoo.goudadev.utils.extensions.TestTags.EASY;
import static org.assertj.core.api.Assertions.assertThat;

@Tags({
    @Tag(EASY)
})
class MergeSortedArrayTest extends AbstractTest {

    MergeSortedArray base = new MergeSortedArray();

    @ParameterizedTest(name = "Case {index}: nums1={0}, m={1}, nums2={2}, n={3}, output={4}")
    @MethodSource("generateTestData")
    void merge_1ms(int[] nums1, int m, int[] nums2, int n, int[] output) {
        assertThat(base.merge_1ms(nums1, m, nums2, n)).isEqualTo(output);
    }

    @ParameterizedTest(name = "Case {index}: nums1={0}, m={1}, nums2={2}, n={3}, output={4}")
    @MethodSource("generateTestData")
    void merge_0ms(int[] nums1, int m, int[] nums2, int n, int[] output) {
        assertThat(base.merge_1ms(nums1, m, nums2, n)).isEqualTo(output);
    }

    @Override
    public Stream<Arguments> generateTestData() {
        return Stream.of(
            Arguments.of(
                new int[]{1},
                1,
                new int[]{},
                0,
                new int[]{1}
            ),
            Arguments.of(
                new int[]{0},
                0,
                new int[]{1},
                1,
                new int[]{1}
            ),
            Arguments.of(
                new int[]{1, 2, 3, 0, 0, 0},
                3,
                new int[]{2, 5, 6},
                3,
                new int[]{1, 2, 2, 3, 5, 6}
            )

        );
    }
}